package com.auth.manazello.controller;

import com.auth.manazello.payload.request.ForgetPasswordDTO;
import com.auth.manazello.payload.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth.manazello.models.Users;
import com.auth.manazello.payload.response.JwtResponse;
import com.auth.manazello.payload.request.LoginRequest;
import com.auth.manazello.payload.request.RegisterRequest;
import com.auth.manazello.repository.UserRepository;
import com.auth.manazello.security.jwt.JwtUtils;
import com.auth.manazello.security.service.IAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final UserRepository userRepository;
    private final IAuthService iAuthService;
    private final JwtUtils jwtUtils;
    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest user) {

        JwtResponse jwtResponse = iAuthService.login(user);

        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest signUpRequest) {
        if (iAuthService.existUserByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
        try {
            return new ResponseEntity<>(iAuthService.register(signUpRequest),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/validateToken/{token}")
    public ResponseEntity<Boolean> verifyToken(@PathVariable String  token) {
        boolean isValide=jwtUtils.validateJwtToken(token);
        return  new ResponseEntity<>( isValide,HttpStatus.OK);
    }
    @GetMapping("/generateToken/{email}")
    public ResponseEntity<String> generateTokenByEmail( @PathVariable String  email) {
       String token= jwtUtils.generateRegistreJwtToken(email);
       logger.info("******* generate token function", token);
        return  new ResponseEntity<>(token, HttpStatus.OK);
    }


    @PostMapping(value= "/forgotPassword",
            consumes = "application/json")
    @ResponseBody
    public ResponseEntity<String> forgetPassword(@RequestBody ForgetPasswordDTO forgetPasswordDTO){
        String token = RandomString.make(150);
        try{

            iAuthService.forgetPasswordToken(token,forgetPasswordDTO.getEmail());

            String resetLink="http://localhost:4200/#/reset_pwd?token=" + token;

            iAuthService.sendEmail(forgetPasswordDTO.getEmail(), resetLink);

        }catch(Exception e){
         return   new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

        @PutMapping("/resetPassword")
    public String resetPassword(@RequestParam("token")String token, @RequestBody ForgetPasswordDTO forgetPasswordDTO ){
        Users users = iAuthService.getByResetPassword(token);
        if(users == null){
            logger.error("invalid token");
            return "Please ! Verify the token!";
        }else {
            return  iAuthService.updatePassword(users,forgetPasswordDTO.getPassword()) ;
        }
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    public List<Users>findAll()
    {
        return userRepository.findAll();

    }


}
