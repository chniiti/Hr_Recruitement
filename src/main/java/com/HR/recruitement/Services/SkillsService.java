package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.Skills;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SkillsService {

    Skills getSkills(Long id);
    List<Skills> getAllSkills();
    Skills addSkills(Skills skills);
    ResponseEntity<String> deleteSkill(Long id);
    ResponseEntity<String> updateSkill(Long id, Skills skills);
}
