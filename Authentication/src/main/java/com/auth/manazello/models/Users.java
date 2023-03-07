package com.auth.manazello.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Document(collection = "users")
public class Users extends User {

    @Id
    private String id;


    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    private String matriculate;

    @NotBlank
    @DBRef
    private Set<Role> roles = new HashSet<>();
    private String resetPassword;


    public Users(String matriculate,String email, String username, String password, String resetPassword, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.email = email;
        this.matriculate=matriculate;


        this.resetPassword = resetPassword;
    }

    @PersistenceConstructor
    public Users(String matriculate,String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String id, String email, Set<Role> roles, String resetPassword) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
        this.matriculate=matriculate;
        this.email = email;
        this.roles = roles;

        this.resetPassword = resetPassword;
    }



}
