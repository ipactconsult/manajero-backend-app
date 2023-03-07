package com.auth.manazello.payload.response;


import com.auth.manazello.models.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String id;
    private String username;
    private String email;
    private List<String> roles;
    private boolean enable;
    private boolean locked;
    private Company company;


    public JwtResponse(String token, String id, String username, String email, List<String> roles, boolean enable, boolean locked, Company company) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.enable = enable;
        this.locked = locked;
        this.company= company;
    }


}
