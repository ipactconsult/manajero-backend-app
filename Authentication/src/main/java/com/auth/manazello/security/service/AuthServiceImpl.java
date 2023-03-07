package com.auth.manazello.security.service;

import com.auth.manazello.models.Company;
import com.auth.manazello.models.Role;
import com.auth.manazello.models.Users;
import com.auth.manazello.payload.request.LoginRequest;
import com.auth.manazello.payload.request.RegisterRequest;
import com.auth.manazello.payload.response.JwtResponse;
import com.auth.manazello.payload.response.RegisterResponse;
import com.auth.manazello.repository.RoleRepository;
import com.auth.manazello.repository.UserRepository;
import com.auth.manazello.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements IAuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

        final
        JavaMailSender javaMailSender;
    final RestTemplate restTemplate;

    final
    UserRepository userRepository;
    final
    RoleRepository roleRepository;
    final
    PasswordEncoder encoder;
    final
    AuthenticationManager authenticationManager;
    final
    JwtUtils jwtUtils;

    @Override
    public JwtResponse login(LoginRequest loginRequest) {
        Optional<Users> userManagedEntity = userRepository.findByEmail(loginRequest.getEmail());

        if (userManagedEntity.isPresent()) {
            Users currentUser = userManagedEntity.get();

//            Company company = restTemplate.getForObject("http://localhost:8092/api/v1/rentalRequest/findByMatriculate/"+currentUser.getMatriculate(), Company.class);
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            List<String> roles = currentUser.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            return new JwtResponse(jwt,
                    currentUser.getId(),
                    currentUser.getUsername(),
                    currentUser.getEmail(),
                    roles,
                    currentUser.isEnabled(),
                    currentUser.isAccountNonLocked(),
                    new Company()
            );
        }
        return null;
    }

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<Role> roles = new HashSet<>();
        for (Role role : registerRequest.getRoles()) {
            if (roleRepository.findByName(role.getName()).isPresent()) {
                Optional<Role> roleManager=roleRepository.findByName(role.getName());
                roleManager.ifPresent(roles::add);
            } else {
                return null;
            }
        }

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        Users user = new Users(registerRequest.getMatriculate(), registerRequest.getEmail(),
                "null",
                encoder.encode(registerRequest.getPassword()),
                "",
                true,
                true,
                true,
                true, authorities);

        user.setRoles(roles);
        RegisterResponse registerResponse =new RegisterResponse();
        userRepository.save(user);
        registerResponse.setEmail(registerRequest.getEmail());
        return registerResponse ;

    }

    @Override
    public boolean existUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }


    public String forgetPasswordToken(String token, String email){
        Users users = userRepository.findByEmail(email).orElse(null);
        if(users.getEmail() != null){
            users.setResetPassword(token);
            userRepository.save(users);
        }else {
            String errorMsg="Could not find any user with email =>"+email;
            logger.error(errorMsg);
        }
        return token;
    }

    @Override
   public void sendEmail(String mail, String resetLink) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail, mail);

        msg.setSubject("Reset your password");
        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + resetLink + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";
        msg.setText(content);

        javaMailSender.send(msg);

    }

    public Users getByResetPassword(String token){
        return userRepository.findByResetPassword(token);
    }

    @Override
    public String updatePassword(Users users, String newPassword) {
        String encodedPassword = encoder.encode(newPassword);

        Users user = new Users(users.getMatriculate(), users.getUsername(), encodedPassword, true,
                true, true, true, users.getAuthorities(), users.getId(), users.getEmail(), users.getRoles(), "");
        userRepository.save(user);
        return "Password Updated Successfully ! ";

    }




}
