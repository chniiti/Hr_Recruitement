package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.Education;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EducationService {

    Education addEducation(Education education);
    List<Education> getAllEducation();
    Education getEducationById(Long id);
    ResponseEntity<String> deleteEducationById(Long id);
    ResponseEntity<String> updateEducation(Long id, Education education);

}
