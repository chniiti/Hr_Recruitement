package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.Skills;
import com.HR.recruitement.Repositories.SkillsRepository;
import com.HR.recruitement.Services.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsServiceImp implements SkillsService {

    @Autowired
    SkillsRepository skillsRepository;

    @Override
    public Skills addSkills(Skills skills) {
        return skillsRepository.save(skills);
    }

    @Override
    public Skills getSkills(Long id) {
        return skillsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Skills> getAllSkills() {
        return skillsRepository.findAll();
    }

    @Override
    public ResponseEntity<String> deleteSkill(Long id) {
        Optional<Skills> skills = skillsRepository.findById(id);
        if (skills.isPresent()) {
            skillsRepository.delete(skills.get());
            return ResponseEntity.ok("Skill deleted successfully");
        }else {
            return ResponseEntity.status(404).body("Skill not found");
        }
    }

    @Override
    public ResponseEntity<String> updateSkill(Long id, Skills skills) {
        Optional<Skills> skills1= skillsRepository.findById(id);
        if (skills1.isPresent()) {
            Skills skills2= skills1.get();
            skills2.setSkillName(skills.getSkillName());
            skills2.setProficiencyLevel(skills.getProficiencyLevel());
            return ResponseEntity.ok("Skill updated successfully");
        }else {
            return ResponseEntity.status(404).body("Skill not found");
        }
    }
}
