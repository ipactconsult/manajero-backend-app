package com.auth.manazello.controller;


import com.auth.manazello.models.Role;
import com.auth.manazello.models.RolesEnum;
import com.auth.manazello.payload.request.RoleRequest;
import com.auth.manazello.security.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/role")
@PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN','ROLE_ADMIN')")
@RequiredArgsConstructor
public class RoleController {
    private final IRoleService iRoleService;
    private final ModelMapper modelMapper;


    @PostMapping("/add")
    public ResponseEntity<Role> addRole(@RequestBody RoleRequest role) {
        Role roleModel = modelMapper.map(role,Role.class);

        Optional<Role> roleFound = iRoleService.getRoleByName(role.getName().name());
        Role roleAdded = roleFound.isPresent() ? null : iRoleService.add(roleModel);
        return ((roleAdded != null)
                ? new ResponseEntity<>(roleAdded, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.FOUND));
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
