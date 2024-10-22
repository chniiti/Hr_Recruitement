package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.Recruiter;
import com.HR.recruitement.Repositories.RecruiterRepository;
import com.HR.recruitement.Services.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterServiceImp implements RecruiterService {

    @Autowired
    RecruiterRepository recruiterRepository;

    @Override
    public Recruiter addRecruiter(Recruiter recruiter) {
        return recruiterRepository.save(recruiter);
    }

    @Override
    public Recruiter getRecruiter(Long id) {
        return recruiterRepository.findById(id).orElse(null);
    }

    public List<Recruiter> getRecruiters() {
        return recruiterRepository.findAll();
    }

    @Override
    public ResponseEntity<String> deleteRecruiter(Long id) {
        Optional<Recruiter> recruiter=recruiterRepository.findById(id);
        if(recruiter.isPresent()) {
            recruiterRepository.delete(recruiter.get());
            return ResponseEntity.ok("Recruiter deleted");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recruiter not found");
        }
    }

    @Override
    public ResponseEntity<String> updateRecruiter(Long id, Recruiter recruiter) {
        Optional<Recruiter> recruiter1=recruiterRepository.findById(id);
        if(recruiter1.isPresent()) {
            Recruiter recruiter2=recruiter1.get();
            recruiter2.setFirstName(recruiter.getFirstName());
            recruiter2.setLastName(recruiter.getLastName());
            recruiter2.setEmail(recruiter.getEmail());
            recruiter2.setPhone(recruiter.getPhone());
            recruiter2.setCin(recruiter.getCin());
            recruiter2.setDateOfBirth(recruiter.getDateOfBirth());
            recruiter2.setPassword(recruiter.getPassword());

            recruiterRepository.save(recruiter2);
            return ResponseEntity.ok("Recruiter updated");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Recruiter not found");
        }
    }
}
