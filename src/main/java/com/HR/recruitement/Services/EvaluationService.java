package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.Evaluation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EvaluationService {

    Evaluation addEvaluation(Evaluation evaluation);
    List<Evaluation> getAllEvaluations();
    Evaluation getEvaluationById(Long id);
    ResponseEntity<String> deleteEvaluationById(Long id);
    ResponseEntity<String> updateEvaluation(Long id, Evaluation evaluation);
    
}
