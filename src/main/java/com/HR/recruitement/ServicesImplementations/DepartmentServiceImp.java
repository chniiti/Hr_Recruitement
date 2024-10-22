package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.Department;
import com.HR.recruitement.Repositories.DepartmentRepository;
import com.HR.recruitement.Services.DepartmentService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public ResponseEntity<String> deleteDepartmentById(Long id) {
        Optional<Department> department=departmentRepository.findById(id);
        if(department.isPresent()){
            departmentRepository.delete(department.get());

            return ResponseEntity.ok().body("Department deleted successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
        }
    }

    @Override
    public ResponseEntity<String> updateDepartment(Long id, Department department) {

        Optional<Department> department1=departmentRepository.findById(id);
        if(department1.isPresent()){
            Department department2=department1.get();
            department2.setName(department.getName());
            department2.setDescription(department.getDescription());
            department2.setLocation(department.getLocation());

            departmentRepository.save(department2);
            return ResponseEntity.ok().body("Department updated successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
        }
    }
}
