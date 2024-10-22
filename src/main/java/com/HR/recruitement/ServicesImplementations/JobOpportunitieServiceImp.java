package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.JobOpportunitie;
import com.HR.recruitement.Repositories.JobOpportunitieRepository;
import com.HR.recruitement.Services.JobOpportunitieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobOpportunitieServiceImp implements JobOpportunitieService {

    @Autowired
    JobOpportunitieRepository jobOpportunitieRepository;

    @Override
    public JobOpportunitie addJobOpportunitie(JobOpportunitie jobOpportunitie) {
        return jobOpportunitieRepository.save(jobOpportunitie);
    }

    @Override
    public JobOpportunitie getJobOpportunitie(Long id) {
        return jobOpportunitieRepository.findById(id).orElse(null);
    }

    @Override
    public List<JobOpportunitie> getAllJobOpportunities() {
        return jobOpportunitieRepository.findAll();
    }

    @Override
    public ResponseEntity<String> deleteJobOpportunitie(Long id) {
        Optional<JobOpportunitie> jobOpportunitie = jobOpportunitieRepository.findById(id);
        if (jobOpportunitie.isPresent()) {
            jobOpportunitieRepository.delete(jobOpportunitie.get());
            return ResponseEntity.ok("Job Opportunitie deleted.");
        }else
            return ResponseEntity.status(404).body("Job Opportunitie not found.");
    }

    @Override
    public ResponseEntity<String> updateJobOpportunitie(Long id, JobOpportunitie jobOpportunitie) {
        Optional<JobOpportunitie> jobOpportunitie1= jobOpportunitieRepository.findById(id);
        if (jobOpportunitie1.isPresent()) {
            JobOpportunitie jobOpportunitie2 = jobOpportunitie1.get();
            jobOpportunitie2.setJobOpportunitieName(jobOpportunitie.getJobOpportunitieName());
            jobOpportunitie2.setDescription(jobOpportunitie.getDescription());
            jobOpportunitie2.setAnnualSalary(jobOpportunitie.getAnnualSalary());
            jobOpportunitie2.setHourlySalary(jobOpportunitie.getHourlySalary());
            jobOpportunitie2.setStartDate(jobOpportunitie.getStartDate());
            jobOpportunitie2.setEndDate(jobOpportunitie.getEndDate());

            return ResponseEntity.ok("Job Opportunitie updated.");
        }else
            return ResponseEntity.status(404).body("Job Opportunitie not found.");
    }
}
