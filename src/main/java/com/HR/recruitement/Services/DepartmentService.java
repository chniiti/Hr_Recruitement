package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.Department;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentService {

    Department getDepartmentById(Long id);
    Department addDepartment(Department department);
    List<Department> getAllDepartments();
    ResponseEntity<String> deleteDepartmentById(Long id);
    ResponseEntity<String> updateDepartment(Long id, Department department);
}
