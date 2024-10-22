package com.HR.recruitement.Controller;

import com.HR.recruitement.Entities.Criteria;
import com.HR.recruitement.Services.CriteriaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Criteria")
@RequiredArgsConstructor
@Slf4j

public class CriteriaController {

    @Autowired
    CriteriaService criteriaService;

    @PostMapping("/add")
    Criteria addCriteria(@RequestBody Criteria criteria) {
        return criteriaService.addCriteriea(criteria);
    }

    @GetMapping("/all")
    List<Criteria> getAllCriteria() {
        return criteriaService.getCriterias();
    }

    @GetMapping("/{id}")
    Criteria getCriteriaById(@RequestParam Long id) {
        return criteriaService.getCriteriaById(id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteCriteriaById(@RequestParam Long id) {
        return criteriaService.deleteCriteria(id);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateCriteria(@RequestParam Long id, @RequestBody Criteria criteria) {
        return criteriaService.updateCriteria(id, criteria);
    }
}
