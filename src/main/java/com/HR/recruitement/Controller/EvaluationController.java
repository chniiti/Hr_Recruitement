package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.Evaluation;
import com.HR.recruitement.Services.EvaluationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Evaluation")
@RequiredArgsConstructor
@Slf4j

public class EvaluationController {

    @Autowired
    EvaluationService evaluationService;

    @PostMapping("/add")
    Evaluation addEvaluation(@RequestBody Evaluation evaluation) {
        return evaluationService.addEvaluation(evaluation);
    }

    @GetMapping("/all")
    List<Evaluation> getAllEvaluations() {
        return evaluationService.getAllEvaluations();
    }

    @GetMapping("/{id}")
    Evaluation getEvaluationsByRecruitementId(@RequestParam Long recruitementId) {
        return evaluationService.getEvaluationById(recruitementId);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteEvaluationById(@RequestParam Long evaluationId) {
        return evaluationService.deleteEvaluationById(evaluationId);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateEvaluation(@RequestParam Long id, @RequestBody Evaluation evaluation) {
        return evaluationService.updateEvaluation(id, evaluation);
    }
}
