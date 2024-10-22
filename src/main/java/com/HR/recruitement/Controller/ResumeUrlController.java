package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.ResumeUrl;
import com.HR.recruitement.Services.ResumeUrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ResumeUrl")
@RequiredArgsConstructor
@Slf4j

public class ResumeUrlController {

    @Autowired
    ResumeUrlService resumeUrlService;

    @PostMapping("/add")
    ResumeUrl addResumeUrl(@RequestBody ResumeUrl resumeUrl) {
        return resumeUrlService.addResumeUrl(resumeUrl);
    }

    @GetMapping("/all")
    List<ResumeUrl> getResumeUrls() {
        return resumeUrlService.getAllResumeUrls();
    }

    @GetMapping("/{id}")
    ResumeUrl getResumeUrlById(@RequestParam Long id) {
        return resumeUrlService.getResumeUrl(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteResumeUrlById(@RequestParam Long id) {
        return resumeUrlService.deleteResumeUrl(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateResumeUrl(@RequestParam Long id, @RequestBody ResumeUrl resumeUrl) {
        return resumeUrlService.updateResumeUrl(id, resumeUrl);
    }
}
