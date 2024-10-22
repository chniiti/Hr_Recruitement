package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.Score;
import com.HR.recruitement.Repositories.ScoreRepository;
import com.HR.recruitement.Services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImp implements ScoreService {

    @Autowired
    ScoreRepository scoreRepository;

    @Override
    public Score addScore(Score score) {
        return scoreRepository.save(score);
    }

    @Override
    public List<Score> getScores() {
        return scoreRepository.findAll();
    }

    @Override
    public Score getScoreById(Long id) {
        return scoreRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<String> deleteScoreById(Long id) {
        Optional<Score> score = scoreRepository.findById(id);
        if (score.isPresent()) {
            scoreRepository.delete(score.get());
            return ResponseEntity.ok("Score deleted successfully");

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Score not found");
        }
    }

    @Override
    public ResponseEntity<String> updateScoreById(Long id, Score score) {
        Optional<Score> score1 = scoreRepository.findById(id);
        if (score1.isPresent()) {
            Score score2 = score1.get();
            score2.setFilePath(score.getFilePath());
            return ResponseEntity.ok("Score updated successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Score not found");
        }
    }
}
