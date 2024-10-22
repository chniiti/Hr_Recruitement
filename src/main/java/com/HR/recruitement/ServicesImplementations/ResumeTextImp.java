package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.ResumeText;
import com.HR.recruitement.Repositories.ResumeRepository;
import com.HR.recruitement.Repositories.ResumeTextRepository;
import com.HR.recruitement.Services.ResumeTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeTextImp implements ResumeTextService {

    @Autowired
    ResumeTextRepository resumeTextRepository;

    @Override
    public ResumeText addResumeText(ResumeText resumeText) {
        return resumeTextRepository.save(resumeText);
    }

    @Override
    public List<ResumeText> getAllResumeTexts() {
        return resumeTextRepository.findAll();
    }

    @Override
    public ResumeText getResumeText(Long id) {
        return resumeTextRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<String> deleteResumeText(Long id) {
        Optional<ResumeText> resumeText = resumeTextRepository.findById(id);
        if (resumeText.isPresent()) {
            resumeTextRepository.delete(resumeText.get());
            return ResponseEntity.ok("Resume Text Deleted");
        }else {
            return ResponseEntity.status(404).body("Resume Text Not Found");
        }
    }

    @Override
    public ResponseEntity<String> updateResumeText(Long id, ResumeText resumeText) {
        Optional<ResumeText> resumeText1= resumeTextRepository.findById(id);
        if (resumeText1.isPresent()) {
            ResumeText resumeText2= resumeText1.get();
            resumeText2.setFilePath(resumeText.getFilePath());
            return ResponseEntity.ok("Resume Text Updated");
        }else {
            return ResponseEntity.status(404).body("Resume Text Not Found");
        }
    }
}
