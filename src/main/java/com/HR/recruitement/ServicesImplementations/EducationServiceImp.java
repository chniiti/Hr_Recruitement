package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.Education;
import com.HR.recruitement.Repositories.EducationRepository;
import com.HR.recruitement.Services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationServiceImp implements EducationService {

    @Autowired
    EducationRepository educationRepository;

    @Override
    public Education addEducation(Education education) {
        return educationRepository.save(education);
    }

    @Override
    public Education getEducationById(Long id) {
        return educationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    @Override
    public ResponseEntity<String> deleteEducationById(Long id) {
        Optional<Education> education = educationRepository.findById(id);
        if (education.isPresent()) {
            educationRepository.delete(education.get());
            return ResponseEntity.ok("Successfully deleted education");
        }else
            return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> updateEducation(Long id, Education education) {
        Optional<Education> education1= educationRepository.findById(id);
        if (education1.isPresent()) {
            Education education2=education1.get();
            education2.setInstitution(education.getInstitution());
            education2.setDegree(education.getDegree());
            education2.setFieldOfStudy(education.getFieldOfStudy());
            education2.setStartDate(education.getStartDate());
            education2.setEndDate(education.getEndDate());

            return  ResponseEntity.ok("Successfully updated education");
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Education not found");
    }
}
