package com.HR.recruitement.Repositories;

import com.HR.recruitement.Entities.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationStatusRepository extends JpaRepository<ApplicationStatus, Long> {
}
