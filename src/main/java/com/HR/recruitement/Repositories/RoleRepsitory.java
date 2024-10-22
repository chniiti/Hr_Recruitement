package com.HR.recruitement.Repositories;

import com.HR.recruitement.Entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepsitory extends JpaRepository<UserRole, Long> {

    Optional<UserRole> findByName(String name);
}
