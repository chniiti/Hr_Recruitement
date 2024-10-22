package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.Candidate;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CandidateService {

    Candidate addCandidate(Candidate candidate);
    List<Candidate> getAllCandidates();
    Candidate getCandidateById(Long id);
    ResponseEntity<String> deleteCandidate(Long id);
    ResponseEntity<String> updateCandidate(Long id, Candidate candidate);
}
