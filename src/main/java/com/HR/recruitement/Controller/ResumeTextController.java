package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.ResumeText;
import com.HR.recruitement.Services.ResumeTextService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ResumeText")
@RequiredArgsConstructor
@Slf4j

public class ResumeTextController {

    @Autowired
    ResumeTextService resumeTextService;

    @PostMapping("/add")
    ResumeText addResumeText(@RequestBody ResumeText resumeText) {
        return resumeTextService.addResumeText(resumeText);
    }

    @GetMapping("/all")
    List<ResumeText> getAllResumeText() {
        return resumeTextService.getAllResumeTexts();
    }

    @GetMapping("/{id}")
    ResumeText getResumeTextById(@RequestParam Long resumeTextId) {
        return resumeTextService.getResumeText(resumeTextId);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteResumeTextById(@RequestParam Long resumeTextId) {
        return resumeTextService.deleteResumeText(resumeTextId);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateResumeText(@RequestParam Long id, @RequestBody ResumeText resumeText) {
        return resumeTextService.updateResumeText(id, resumeText);
    }
}
