package com.HR.recruitement.Controller;


import com.HR.recruitement.Entities.Candidate;
import com.HR.recruitement.Services.CandidateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("candidate")
@RequiredArgsConstructor
@Slf4j

public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @PostMapping("/add")
    Candidate addCandidate(@RequestBody Candidate candidate) {
        return candidateService.addCandidate(candidate);
    }

    @GetMapping("/all")
    List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @GetMapping("/{id}")
    Candidate getCandidateById(@RequestParam Long id) {
        return candidateService.getCandidateById(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteCandidateById(@RequestParam Long id) {
        return candidateService.deleteCandidate(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateCandidate(@RequestParam Long id, @RequestBody Candidate candidate) {
        return candidateService.updateCandidate(id, candidate);
    }
}
