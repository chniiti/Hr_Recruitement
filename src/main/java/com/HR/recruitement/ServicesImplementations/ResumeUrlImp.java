package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.ResumeUrl;
import com.HR.recruitement.Repositories.ResumeUrlRepository;
import com.HR.recruitement.Services.ResumeUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeUrlImp implements ResumeUrlService {

    @Autowired
    ResumeUrlRepository resumeUrlRepository;

    @Override
    public ResumeUrl getResumeUrl(Long id) {
        return resumeUrlRepository.findById(id).orElse(null);
    }

    @Override
    public List<ResumeUrl> getAllResumeUrls() {
        return resumeUrlRepository.findAll();
    }

    @Override
    public ResumeUrl addResumeUrl(ResumeUrl resumeUrl) {
        return resumeUrlRepository.save(resumeUrl);
    }

    @Override
    public ResponseEntity<String> deleteResumeUrl(Long id) {
        Optional<ResumeUrl> resumeUrl = resumeUrlRepository.findById(id);
        if (resumeUrl.isPresent()) {
            resumeUrlRepository.delete(resumeUrl.get());
            return ResponseEntity.ok("Resume Url deleted");
        }else {
            return ResponseEntity.status(404).body("Resume Url not found");
        }
    }

    @Override
    public ResponseEntity<String> updateResumeUrl(Long id, ResumeUrl resumeUrl) {
        Optional<ResumeUrl> resumeUrl1 = resumeUrlRepository.findById(id);
        if (resumeUrl1.isPresent()) {
            ResumeUrl resumeUrl2 = resumeUrl1.get();
            resumeUrl2.setUrl(resumeUrl.getUrl());

            return ResponseEntity.ok("Resume Url updated");
        } else {
            return ResponseEntity.status(404).body("Resume Url not found");
        }
    }
}

