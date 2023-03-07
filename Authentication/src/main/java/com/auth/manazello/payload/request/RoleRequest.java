package com.auth.manazello.payload.request;

import com.auth.manazello.models.RolesEnum;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequest {
    private RolesEnum name;

}
