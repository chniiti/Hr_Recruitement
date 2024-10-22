package com.HR.recruitement.Repositories;

import com.HR.recruitement.Entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
}
