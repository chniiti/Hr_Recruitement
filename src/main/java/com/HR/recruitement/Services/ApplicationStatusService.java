package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.ApplicationStatus;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ApplicationStatusService {

    ApplicationStatus getApplicationStatusById(Long id);
    ApplicationStatus addApplicationStatus(ApplicationStatus applicationStatus);
    ResponseEntity<String> updateApplicationStatus(Long id, ApplicationStatus applicationStatus);
    ResponseEntity<String> deleteApplicationStatus(Long id);
   List<ApplicationStatus> getAllApplicationStatus();
}
