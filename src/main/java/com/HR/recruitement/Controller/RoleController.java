package com.HR.recruitement.Controller;


import com.HR.recruitement.Entities.UserRole;
import com.HR.recruitement.Services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    @Autowired
    RoleService roleService;


    @PostMapping("/saveRole")
    public UserRole saveRole(@RequestBody UserRole role) {
        return roleService.saveRole(role);
    }

    @GetMapping("/getRoles")
    public List<UserRole> getRoles() {
        return roleService.getRoles();
    }
}
