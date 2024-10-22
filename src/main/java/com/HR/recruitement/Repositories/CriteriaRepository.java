package com.HR.recruitement.Repositories;

import com.HR.recruitement.Entities.Criteria;
import com.HR.recruitement.Entities.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriteriaRepository extends JpaRepository<Criteria,Long> {
}
