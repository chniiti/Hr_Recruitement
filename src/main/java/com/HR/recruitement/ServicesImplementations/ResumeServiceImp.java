package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.Resume;
import com.HR.recruitement.Repositories.ResumeRepository;
import com.HR.recruitement.Services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeServiceImp implements ResumeService {

    @Autowired
    ResumeRepository resumeRepository;

    @Override
    public List<Resume> getResumes() {
        return resumeRepository.findAll();
    }

    @Override
    public Resume getResume(Long id) {
        return resumeRepository.findById(id).orElse(null);
    }

    @Override
    public Resume addResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    @Override
    public ResponseEntity<String> deleteResume(Long id) {
        Optional<Resume> resume = resumeRepository.findById(id);
        if (resume.isPresent()) {
            resumeRepository.delete(resume.get());
            return ResponseEntity.ok("Resume deleted");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resume not found");
        }
    }

    @Override
    public ResponseEntity<String> updateResume(Long id, Resume resume) {
        Optional<Resume> resume1= resumeRepository.findById(id);
        if (resume1.isPresent()) {
            Resume resume2= resume1.get();

            resume2.setActive(resume.getActive());
            resumeRepository.save(resume2);
            return ResponseEntity.ok("Resume updated");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resume not found");
        }
    }
}
