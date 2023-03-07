package com.auth.manazello.controller;


import com.auth.manazello.models.Role;
import com.auth.manazello.payload.request.RoleRequest;
import com.auth.manazello.security.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    IRoleService iRoleService;

    @PostMapping("/add")
    public void addRole(@RequestBody RoleRequest role) {
        Role newRole = new Role("ROLE_".concat(role.getName().toUpperCase()));
        iRoleService.add(newRole);

    }
    @PostMapping("/findAll")
    public ResponseEntity<List<Role>> findAll() {

       List<Role> roleList= iRoleService.getAllRole();
       if(!roleList.isEmpty())
       {
           return  new ResponseEntity<>(roleList, HttpStatus.OK);
       }
       else{
           return  new ResponseEntity<>( HttpStatus.NO_CONTENT);

       }

    }
}
