package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.Education;
import com.HR.recruitement.Entities.Experience;
import com.HR.recruitement.Repositories.ExperienceRepository;
import com.HR.recruitement.Services.EducationService;
import com.HR.recruitement.Services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceServiceImp implements ExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;

    @Override
    public Experience addExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public List<Experience> getAllExperience() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience getExperience(Long id) {
        return experienceRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<String> deleteExperience(Long id) {
        Optional<Experience> experience = experienceRepository.findById(id);
        if (experience.isPresent()) {
            experienceRepository.delete(experience.get());
            return ResponseEntity.ok("Experience deleted");
        }else
            return ResponseEntity.status(404).body("Experience not found");
    }

    @Override
    public ResponseEntity<String> updateExperience(Long id, Experience experience) {
        Optional<Experience> experience1= experienceRepository.findById(id);
        if (experience1.isPresent()) {
            Experience experience2= experience1.get();
            experience2.setStarDate(experience.getStarDate());
            experience2.setEndDate(experience.getEndDate());
            experience2.setResponsibilities(experience.getResponsibilities());
            return ResponseEntity.ok("Experience updated");
        }else
            return ResponseEntity.status(404).body("Experience not found");
    }
}
