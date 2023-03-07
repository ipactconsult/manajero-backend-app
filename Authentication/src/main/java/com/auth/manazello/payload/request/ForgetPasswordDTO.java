package com.auth.manazello.payload.request;

import lombok.Getter;

@Getter
public class ForgetPasswordDTO {
    private String email;
    private String password;

}
