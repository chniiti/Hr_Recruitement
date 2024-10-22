package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.Skills;
import com.HR.recruitement.Repositories.SkillsRepository;
import com.HR.recruitement.Services.SkillsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Skills")
@RequiredArgsConstructor
@Slf4j

public class SkillsConroller {

    @Autowired
    SkillsService skillsService;

    @PostMapping("/add")
    Skills addSkills(@RequestBody Skills skills) {
        return skillsService.addSkills(skills);
    }

    @GetMapping("/all")
    List<Skills> getAllSkills() {
        return skillsService.getAllSkills();
    }

    @GetMapping("/{id}")
    Skills getSkillById(@RequestParam Long id) {
        return skillsService.getSkills(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteSkillById(@RequestParam Long id) {
        return skillsService.deleteSkill(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateSkill(@RequestParam Long id, @RequestBody Skills skills) {
        return skillsService.updateSkill(id, skills);
    }
}
