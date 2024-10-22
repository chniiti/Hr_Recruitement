package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.Department;
import com.HR.recruitement.Services.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Department")
@RequiredArgsConstructor
@Slf4j

public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/add")
    Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @GetMapping("/all")
    List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    Department getDepartmentById(@RequestParam Long id) {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteDepartmentById(@RequestParam Long id) {
        return departmentService.deleteDepartmentById(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateDepartment(@RequestParam Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }
}
