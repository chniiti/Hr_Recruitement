package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.Experience;
import com.HR.recruitement.Services.ExperienceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Experience")
@RequiredArgsConstructor
@Slf4j

public class ExperienceController {

    @Autowired
    ExperienceService experienceService;

    @PostMapping("/add")
    Experience addExperience(@RequestBody Experience experience) {
        return experienceService.addExperience(experience);
    }

    @GetMapping("/all")
    List<Experience> getAllExperience() {
        return experienceService.getAllExperience();
    }

    @GetMapping("/{id}")
    Experience getExperienceById(@RequestParam Long id) {
        return experienceService.getExperience(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteExperienceById(@RequestParam Long id) {
        return experienceService.deleteExperience(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateExperience(@RequestParam Long id, @RequestBody Experience experience) {
        return experienceService.updateExperience(id, experience);
    }
}
