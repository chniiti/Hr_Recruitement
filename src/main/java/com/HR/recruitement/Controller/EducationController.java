package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.Education;
import com.HR.recruitement.Services.EducationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Education")
@RequiredArgsConstructor
@Slf4j

public class EducationController {

    @Autowired
    EducationService educationService;

    @PostMapping("/add")
    Education addEducation(@RequestBody Education education) {
        return educationService.addEducation(education);
    }

    @GetMapping("/all")
    List<Education> getAllEducation() {
        return educationService.getAllEducation();
    }

    @GetMapping("/{id}")
    Education getEducationById(@RequestParam Long id) {
        return educationService.getEducationById(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteEducationById(@RequestParam Long id) {
        return educationService.deleteEducationById(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateEducation(@RequestParam Long id, @RequestBody Education education) {
        return educationService.updateEducation(id, education);
    }
}
