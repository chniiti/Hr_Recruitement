package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.ApplicationStatus;
import com.HR.recruitement.Services.ApplicationStatusService;
import com.HR.recruitement.Services.EvaluationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ApplicationStatus")
@RequiredArgsConstructor
@Slf4j

public class ApplicationStatusController {

    @Autowired
    ApplicationStatusService applicationStatusService;

    @PostMapping("/add")
    ApplicationStatus addApplicationStatus(@RequestBody ApplicationStatus applicationStatus) {
        return applicationStatusService.addApplicationStatus(applicationStatus);
    }

    @GetMapping("/all")
    List<ApplicationStatus> getAllApplicationStatus() {
        return applicationStatusService.getAllApplicationStatus();
    }

    @GetMapping("/{applicationStatusId}")
    ApplicationStatus getApplicationStatus(@RequestParam Long applicationStatusId) {
        return applicationStatusService.getApplicationStatusById(applicationStatusId);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteApplicationStatus(@RequestParam Long applicationStatusId) {
        return applicationStatusService.deleteApplicationStatus(applicationStatusId);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateApplicationStatus(@RequestParam Long id, @RequestBody ApplicationStatus applicationStatus) {
        return applicationStatusService.updateApplicationStatus(id, applicationStatus);
    }
}
