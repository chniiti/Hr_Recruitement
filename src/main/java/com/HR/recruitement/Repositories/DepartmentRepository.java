package com.HR.recruitement.Repositories;

import com.HR.recruitement.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
