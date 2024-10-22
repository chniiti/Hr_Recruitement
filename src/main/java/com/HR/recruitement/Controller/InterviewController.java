package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.Interview;
import com.HR.recruitement.Repositories.InterviewRepository;
import com.HR.recruitement.Services.InterviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Interview")
@RequiredArgsConstructor
@Slf4j

public class InterviewController {
    @Autowired
    InterviewService interviewService;

    @PostMapping("/add")
    Interview addInterview(@RequestBody Interview interview) {
        return interviewService.addInterview(interview);
    }

    @GetMapping("/all")
    List<Interview> getInterviews() {
        return interviewService.getInterviews();
    }

    @GetMapping("/{id}")
    Interview getInterview(@RequestParam Long id) {
        return interviewService.getInterview(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteInterview(@RequestParam Long id) {
       return interviewService.deleteInterview(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateInterview(@RequestParam Long id, @RequestBody Interview interview) {
        return interviewService.updateInterview(id, interview);
    }
}
