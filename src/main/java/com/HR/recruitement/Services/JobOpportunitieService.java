package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.JobOpportunitie;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobOpportunitieService {

    JobOpportunitie getJobOpportunitie(Long id);
    List<JobOpportunitie> getAllJobOpportunities();
    JobOpportunitie addJobOpportunitie(JobOpportunitie jobOpportunitie);
    ResponseEntity<String> deleteJobOpportunitie(Long id);
    ResponseEntity<String> updateJobOpportunitie(Long id, JobOpportunitie jobOpportunitie);

}
