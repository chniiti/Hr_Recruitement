package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.Application;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ApplicationService {

    Application addAppliaction(Application application);
    List<Application> getAllAppliactions();
    Application getApplicationById(Long id);
    ResponseEntity<String> deleteApplicationById(Long id);
    ResponseEntity<String> updateApplication(Long id, Application application);
   //ResponseEntity<String> updateApplicationByResume(Long id, Application application);
}
