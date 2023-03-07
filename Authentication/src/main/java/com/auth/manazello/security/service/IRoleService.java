package com.auth.manazello.security.service;

import com.auth.manazello.models.Role;

import java.util.List;

public interface  IRoleService {
     Role add(Role role);
    List<Role> getAllRole();
}
