package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.Resume;
import com.HR.recruitement.Services.ResumeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Resume")
@RequiredArgsConstructor
@Slf4j

public class ResumeController {

    @Autowired
    ResumeService resumeService;

    @PostMapping("/add")
    Resume addResume(@RequestBody Resume resume) {
        return resumeService.addResume(resume);
    }

    @GetMapping("/amm")
    List<Resume> getAllResume() {
        return  resumeService.getResumes();
    }

    @GetMapping("/{id}")
    Resume getResume(Long id) {
        return resumeService.getResume(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteResume(@RequestParam Long id) {
        return resumeService.deleteResume(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateResume(@RequestParam Long id, @RequestBody Resume resume) {
        return resumeService.updateResume(id, resume);
    }
}
