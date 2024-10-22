package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.UserRole;
import com.HR.recruitement.Repositories.RoleRepsitory;
import com.HR.recruitement.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    RoleRepsitory roleRepsitory;

    @Override
    public UserRole saveRole(UserRole role) {
        return roleRepsitory.save(role);
    }

    @Override
    public List<UserRole> getRoles() {
        return roleRepsitory.findAll();
    }

    @Override
    public Optional<UserRole> findRoleByName(String roleName) {
        return roleRepsitory.findByName(roleName);
    }


}
