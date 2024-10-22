package com.HR.recruitement.Services;

import com.HR.recruitement.Entities.Criteria;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CriteriaService {

    Criteria addCriteriea(Criteria criteria);
    Criteria getCriteriaById(Long id);
    List<Criteria> getCriterias();
    ResponseEntity<String> deleteCriteria(Long id);
    ResponseEntity<String> updateCriteria(Long id, Criteria criteria);
}
