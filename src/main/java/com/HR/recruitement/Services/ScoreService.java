package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.Score;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScoreService {

    Score addScore(Score score);
    List<Score> getScores();
    Score getScoreById(Long id);
    ResponseEntity<String> deleteScoreById(Long id);
    ResponseEntity<String> updateScoreById(Long id, Score score);
}
