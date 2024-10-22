package com.HR.recruitement.Repositories;

import com.HR.recruitement.Entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRespository extends JpaRepository<Candidate, Long> {
}
