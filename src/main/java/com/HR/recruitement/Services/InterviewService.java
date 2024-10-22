package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.Interview;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InterviewService {

    Interview getInterview(Long id);
    Interview addInterview(Interview interview);
    List<Interview> getInterviews();
    ResponseEntity<String> deleteInterview(Long id);
    ResponseEntity<String> updateInterview(Long id, Interview interview);
}
