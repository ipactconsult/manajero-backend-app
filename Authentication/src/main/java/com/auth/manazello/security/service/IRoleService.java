package com.auth.manazello.security.service;

import com.auth.manazello.models.Role;

import java.util.List;
import java.util.Optional;

public interface  IRoleService {
     Role add(Role role);
    List<Role> getAllRole();

    Optional<Role> getRoleByName(String name);
}
