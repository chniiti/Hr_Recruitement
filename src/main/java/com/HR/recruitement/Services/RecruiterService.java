package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.Interview;
import com.HR.recruitement.Entities.Recruiter;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RecruiterService {

    Recruiter getRecruiter(Long id);
    Recruiter addRecruiter(Recruiter recruiter);
    List<Recruiter> getRecruiters();
    ResponseEntity<String> deleteRecruiter(Long id);
    ResponseEntity<String> updateRecruiter(Long id, Recruiter recruiter);
}
