package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.Evaluation;
import com.HR.recruitement.Repositories.EvaluationRepository;
import com.HR.recruitement.Services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationServiceImp implements EvaluationService {

    @Autowired
    EvaluationRepository evaluationRepository;

    @Override
    public Evaluation addEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    @Override
    public Evaluation getEvaluationById(Long id) {
        return evaluationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    @Override
    public ResponseEntity<String> deleteEvaluationById(Long id) {
        Optional<Evaluation> evaluation = evaluationRepository.findById(id);
        if (evaluation.isPresent()) {
            evaluationRepository.delete(evaluation.get());
            return ResponseEntity.ok("Evaluation deleted");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evaluation Not Found");
        }
    }

    @Override
    public ResponseEntity<String> updateEvaluation(Long id, Evaluation evaluation) {
        Optional<Evaluation> evaluation1 =evaluationRepository.findById(id);
        if (evaluation1.isPresent()) {
            Evaluation evaluation2=evaluation1.get();

            evaluation2.setComments(evaluation.getComments());
            evaluationRepository.save(evaluation2);
            return ResponseEntity.ok("Evaluation updated");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evaluation Not Found");
        }
    }
}
