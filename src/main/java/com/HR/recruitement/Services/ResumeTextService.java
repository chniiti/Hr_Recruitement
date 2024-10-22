package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.ResumeText;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResumeTextService {

    ResumeText getResumeText(Long id);
    ResumeText addResumeText(ResumeText resumeText);
    List<ResumeText> getAllResumeTexts();
    ResponseEntity<String> deleteResumeText(Long id);
    ResponseEntity<String> updateResumeText(Long id, ResumeText resumeText);

}
