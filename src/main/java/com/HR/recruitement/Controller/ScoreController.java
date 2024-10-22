package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.Score;
import com.HR.recruitement.Services.ScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Score")
@RequiredArgsConstructor
@Slf4j

public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @PostMapping("/add")
    Score addScore(@RequestBody Score score) {
        return scoreService.addScore(score);
    }

    @GetMapping("/all")
    List<Score> getScores() {
        return scoreService.getScores();
    }

    @GetMapping("/{id}")
    Score getScoreById(@RequestParam Long id) {
        return scoreService.getScoreById(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteScoreById(@RequestParam Long id) {
        return scoreService.deleteScoreById(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateScoreById(@RequestParam Long id, @RequestBody Score score) {
        return scoreService.updateScoreById(id, score);
    }
}
