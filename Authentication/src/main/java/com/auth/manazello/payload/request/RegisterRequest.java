package com.auth.manazello.payload.request;

import com.auth.manazello.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {


    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    private String password;



    @NotBlank
    private Set<Role> roles = new HashSet<>();

    private String matriculate;


}
