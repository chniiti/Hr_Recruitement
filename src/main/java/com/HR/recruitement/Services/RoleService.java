package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.UserRole;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    UserRole saveRole(UserRole role);
    List<UserRole> getRoles();
    Optional<UserRole> findRoleByName(String roleName);

}
