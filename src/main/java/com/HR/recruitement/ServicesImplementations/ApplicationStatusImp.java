package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.ApplicationStatus;
import com.HR.recruitement.Repositories.ApplicationStatusRepository;
import com.HR.recruitement.Services.ApplicationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationStatusImp implements ApplicationStatusService {

    @Autowired
    ApplicationStatusRepository applicationStatusRepository;

    @Override
    public ApplicationStatus addApplicationStatus(ApplicationStatus applicationStatus) {
        return applicationStatusRepository.save(applicationStatus);
    }


    public ApplicationStatus getApplicationStatusById(Long id) {
        return applicationStatusRepository.findById(id).orElse(null);
    }

    public List<ApplicationStatus> getAllApplicationStatus() {
        return applicationStatusRepository.findAll();
    }

    @Override
    public ResponseEntity<String> deleteApplicationStatus(Long id) {
        Optional<ApplicationStatus> applicationStatus=applicationStatusRepository.findById(id);
        if(applicationStatus.isPresent()){
            applicationStatusRepository.deleteById(id);
            return ResponseEntity.ok("Application Status deleted successfully");

        }else {
            return ResponseEntity.ok("Application Status not found");
        }
    }

    @Override
    public ResponseEntity<String> updateApplicationStatus(Long id, ApplicationStatus applicationStatus){
        Optional<ApplicationStatus> applicationStatus1=applicationStatusRepository.findById(id);
        if(applicationStatus1.isPresent()){
            ApplicationStatus applicationStatus2=applicationStatusRepository.findById(id).get();

            applicationStatus2.setStatusName(applicationStatus.getStatusName());
            applicationStatus2.setDescription(applicationStatus.getDescription());

            return ResponseEntity.ok("Application Status updated successfully");
        }else
        return ResponseEntity.ok("Application Status not found");
    }
}
