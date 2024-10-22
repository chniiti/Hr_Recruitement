package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.Experience;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExperienceService {

    Experience getExperience(Long id);
    List<Experience> getAllExperience();
    Experience addExperience(Experience experience);
    ResponseEntity<String> deleteExperience(Long id);
    ResponseEntity<String> updateExperience(Long id, Experience experience);
}
