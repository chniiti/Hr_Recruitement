package com.HR.recruitement.Repositories;

import com.HR.recruitement.Entities.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
