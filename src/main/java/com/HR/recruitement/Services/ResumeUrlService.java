package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.ResumeText;
import com.HR.recruitement.Entities.ResumeUrl;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResumeUrlService {

    ResumeUrl getResumeUrl(Long id);
    ResumeUrl addResumeUrl(ResumeUrl resumeUrl);
    List<ResumeUrl> getAllResumeUrls();
    ResponseEntity<String> deleteResumeUrl(Long id);
    ResponseEntity<String> updateResumeUrl(Long id, ResumeUrl resumeUrl);

}
