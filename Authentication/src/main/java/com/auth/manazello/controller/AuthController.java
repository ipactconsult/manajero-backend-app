package com.auth.manazello.controller;

import com.auth.manazello.payload.request.ForgetPasswordDTO;
import com.auth.manazello.payload.response.RegisterResponse;
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
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);


    UserRepository userRepository;


    final
    IAuthService iAuthService;

    final JwtUtils jwtUtils;

    public AuthController(IAuthService iAuthService, JwtUtils jwtUtils) {
        this.iAuthService = iAuthService;
        this.jwtUtils = jwtUtils;
    }


    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest user) {
        System.out.println(user.getEmail());

        JwtResponse jwtResponse = iAuthService.login(user);
        System.out.println(jwtResponse.getEmail());
        System.out.println(user.getPassword());

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
    public ResponseEntity<String> test( @PathVariable String  email) {
       String token= jwtUtils.generateRegistreJwtToken(email);
       logger.info("******* generate token function", token);
        return  new ResponseEntity<>(token, HttpStatus.OK);
    }


    @PostMapping(value= "/forget_password",
            consumes = "application/json")
    @ResponseBody
    public ResponseEntity<String> forgetPassword(@RequestBody ForgetPasswordDTO email){
        String token = RandomString.make(150);
        try{

            iAuthService.forgetPasswordToken(token,email.getEmail());

            String resetLink="http://localhost:8081/api/auth/reset_password?token=" + token;

            iAuthService.sendEmail(email.getEmail(), resetLink);


        }catch(Exception e){
         return   new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

        @PutMapping("/reset_password")
    public String resetPassword(@RequestParam("token")String token, @RequestBody ForgetPasswordDTO  password ){
        Users users = iAuthService.getByResetPassword(token);
        if(users == null){
            logger.error("invalid token");
            return "Please ! Verify the token!";
        }else {
            return  iAuthService.updatePassword(users,password.getPassword()) ;


        }

    }



    @GetMapping("/users")
    public List<Users>findAll()
    {
            return userRepository.findAll();

    }


}
