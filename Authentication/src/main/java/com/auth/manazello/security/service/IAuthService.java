package com.auth.manazello.security.service;

import com.auth.manazello.models.Users;
import com.auth.manazello.payload.request.LoginRequest;
import com.auth.manazello.payload.request.RegisterRequest;
import com.auth.manazello.payload.response.JwtResponse;
import com.auth.manazello.payload.response.RegisterResponse;
import org.springframework.mail.SimpleMailMessage;

public interface  IAuthService {
     JwtResponse login(LoginRequest loginRequest);
     RegisterResponse register(RegisterRequest registerRequest);
     boolean existUserByEmail(String email);
     String forgetPasswordToken(String token, String email);
     Users getByResetPassword(String token);
     String updatePassword(Users users, String newPassword);
     void sendEmail(String mail, String resetLink) ;
}
