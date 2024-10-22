package com.HR.recruitement.Repositories;

import com.HR.recruitement.Entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
