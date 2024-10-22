package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.JobOpportunitie;
import com.HR.recruitement.Services.JobOpportunitieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("JobOpportunitie")
@RequiredArgsConstructor
@Slf4j

public class JobOpportunitieController {

    @Autowired
    JobOpportunitieService jobOpportunitieService;

    @PutMapping("/add")
    JobOpportunitie add(@RequestBody JobOpportunitie jobOpportunitie) {
        return jobOpportunitieService.addJobOpportunitie(jobOpportunitie);
    }

    @GetMapping("/all")
    List<JobOpportunitie> getAll() {
        return jobOpportunitieService.getAllJobOpportunities();
    }

    @GetMapping("/{id}")
    JobOpportunitie getJobOpportunitie(@RequestParam Long id) {
        return jobOpportunitieService.getJobOpportunitie(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@RequestParam Long id) {
        return jobOpportunitieService.deleteJobOpportunitie(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> update(@RequestParam Long id, @RequestBody JobOpportunitie jobOpportunitie) {
        return jobOpportunitieService.updateJobOpportunitie(id, jobOpportunitie);
    }
}
