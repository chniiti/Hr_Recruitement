package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.Interview;
import com.HR.recruitement.Repositories.InterviewRepository;
import com.HR.recruitement.Services.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewServiceImp implements InterviewService {

    @Autowired
    InterviewRepository interviewRepository;

    @Override
    public Interview addInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public Interview getInterview(Long id) {
        return interviewRepository.findById(id).orElse(null);
    }

    @Override
    public List<Interview> getInterviews() {
        return interviewRepository.findAll();
    }

    @Override
    public ResponseEntity<String> deleteInterview(Long id) {

        Optional<Interview> interview = interviewRepository.findById(id);
        if (interview.isPresent()) {
            interviewRepository.delete(interview.get());
            return ResponseEntity.ok("Interview deleted");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Interview not found");
        }
    }

    @Override
    public ResponseEntity<String> updateInterview(Long id, Interview interview) {
        Optional<Interview> interview1 = interviewRepository.findById(id);
        if (interview1.isPresent()) {
            Interview interview2=interview1.get();
            interview2.setInterviewDate(interview.getInterviewDate());
            interview2.setFeedback(interview.getFeedback());

            interviewRepository.save(interview2);

            return ResponseEntity.ok("Interview updated");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Interview not found");
        }
    }
}
