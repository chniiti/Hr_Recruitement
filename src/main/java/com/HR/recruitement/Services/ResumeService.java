package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.Recruiter;
import com.HR.recruitement.Entities.Resume;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResumeService {

    Resume getResume(Long id);
    Resume addResume (Resume resume);
    List<Resume> getResumes();
    ResponseEntity<String> deleteResume(Long id);
    ResponseEntity<String> updateResume(Long id, Resume resume);
}
