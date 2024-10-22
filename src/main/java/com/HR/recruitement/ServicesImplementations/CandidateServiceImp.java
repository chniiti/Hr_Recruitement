package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.Candidate;
import com.HR.recruitement.Repositories.CandidateRespository;
import com.HR.recruitement.Services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImp implements CandidateService {

    @Autowired
    CandidateRespository candidateRespository;

    @Override
    public Candidate addCandidate(Candidate candidate) {
        return candidateRespository.save(candidate);
    }

    @Override
    public Candidate getCandidateById(Long id) {
        return candidateRespository.findById(id).orElse(null);
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRespository.findAll();
    }

    @Override
    public ResponseEntity<String> updateCandidate(Long id, Candidate candidate) {

        Optional<Candidate> c = candidateRespository.findById(id);
        if (c.isPresent()) {
            Candidate c1 = c.get();
            c1.setFirstName(candidate.getFirstName());
            c1.setLastName(candidate.getLastName());
            c1.setEmail(candidate.getEmail());
            c1.setPhone(candidate.getPhone());
            c1.setEmail(candidate.getEmail());
            c1.setPassword(candidate.getPassword());
            c1.setCin(candidate.getCin());
            c1.setDateOfBirth(candidate.getDateOfBirth());
            c1.setResumes(candidate.getResumes());
            c1.setDocuments(candidate.getDocuments());

            candidateRespository.save(c1);

            return ResponseEntity.ok().body("candidate updated successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Candidate not found");
        }
    }

    @Override
    public ResponseEntity<String> deleteCandidate(Long id) {

        Optional<Candidate> candidate=candidateRespository.findById(id);
        if (candidate.isPresent()) {
            candidateRespository.deleteById(id);
             return ResponseEntity.ok().body("candidate deleted successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Candidate not found");
        }
    }
}
