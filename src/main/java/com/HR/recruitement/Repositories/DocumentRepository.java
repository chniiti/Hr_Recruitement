package com.HR.recruitement.Repositories;

import com.HR.recruitement.Entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
