package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.Application;
import com.HR.recruitement.Entities.Candidate;
import com.HR.recruitement.Entities.Resume;
import com.HR.recruitement.Repositories.ApplicationRepository;
import com.HR.recruitement.Services.ApplicationService;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImp implements ApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public Application addAppliaction(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> getAllAppliactions() {
        return applicationRepository.findAll();
    }

    @Override
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<String> deleteApplicationById(Long id) {
        Optional<Application> application = applicationRepository.findById(id);
        if (application.isPresent()) {
            applicationRepository.delete(application.get());
            return ResponseEntity.ok().body("Application deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Application not found");
        }

    }

    @Override
    public ResponseEntity<String> updateApplication(Long id, Application application) {

        Optional<Application> application1= applicationRepository.findById(id);
        if (application1.isPresent()) {
            Application application2= application1.get();



            applicationRepository.save(application2);

            return ResponseEntity.ok().body("Application updated successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Application not found");
        }
    }

    /*@Override
    public ResponseEntity<String> updateApplicationByResume(Long id, Application application) {
        Optional<Application> application1= applicationRepository.findById(id);
        if (application1.isPresent()) {
            Application application2= application1.get();
            Candidate candidate= application.getCandidate();
            List<Resume> resumes=candidate.getResumes();

            boolean isResumeUpdated=false;
            for(Resume resume:resumes){
                if(res)
            }
        }
        return null;
    }*/
}
