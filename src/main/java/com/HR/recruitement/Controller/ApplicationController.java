package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.Application;
import com.HR.recruitement.Services.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Application")
@RequiredArgsConstructor
@Slf4j

public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @PostMapping("/add")
    Application addApplication(@RequestBody Application application) {
        return applicationService.addAppliaction(application);
    }

    @GetMapping("/allApplications")
    List<Application> getAllApplications() {
        return applicationService.getAllAppliactions();
    }

    @GetMapping("/{id}")
    Application getApplicationById(@RequestParam Long id) {
        return applicationService.getApplicationById(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteApplicationById(@RequestParam Long id) {
        return applicationService.deleteApplicationById(id);

    }

    @PutMapping("/{id}")
    ResponseEntity<String> updateApplication(@RequestParam Long id, @RequestBody Application application) {
        return applicationService.updateApplication(id, application);
    }
}
