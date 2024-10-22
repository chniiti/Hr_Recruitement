package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.Recruiter;
import com.HR.recruitement.Services.RecruiterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recruiter")
@RequiredArgsConstructor
@Slf4j

public class RecruiterController {

    @Autowired
    RecruiterService recruiterService;

    @PostMapping("/add")
    Recruiter addRecruiter(@RequestBody Recruiter recruiter) {
        return recruiterService.addRecruiter(recruiter);
    }

    @GetMapping("/all")
    List<Recruiter> getAllRecruiters() {
        return recruiterService.getRecruiters();
    }

    @GetMapping("/{id}")
    Recruiter getRecruiterById(@RequestParam Long id) {
        return recruiterService.getRecruiter(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteRecruiterById(@RequestParam Long id) {
        return recruiterService.deleteRecruiter(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateRecruiter(@RequestParam Long id, @RequestBody Recruiter recruiter) {
        return recruiterService.updateRecruiter(id, recruiter);
    }
}
