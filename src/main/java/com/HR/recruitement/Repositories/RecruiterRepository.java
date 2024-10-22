package com.HR.recruitement.Repositories;

import com.HR.recruitement.Entities.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
}
