package com.HR.recruitement.ServicesImplementations;

import com.HR.recruitement.Entities.Criteria;
import com.HR.recruitement.Repositories.CriteriaRepository;
import com.HR.recruitement.Services.CriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriteriaServiceImp implements CriteriaService {

    @Autowired
    CriteriaRepository criteriaRepository;

    @Override
    public Criteria addCriteriea(Criteria criteria) {
        return criteriaRepository.save(criteria);
    }

    @Override
    public Criteria getCriteriaById(Long id) {
        return criteriaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Criteria> getCriterias() {
        return criteriaRepository.findAll();
    }

    @Override
    public ResponseEntity<String> deleteCriteria(Long id) {
        Optional<Criteria> criteria=criteriaRepository.findById(id);
        if(criteria.isPresent()) {
            criteriaRepository.deleteById(id);
            return ResponseEntity.ok().body("Criteria deleted successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Criteria not found");
        }
    }

    @Override
    public ResponseEntity<String> updateCriteria(Long id, Criteria criteria) {
        Optional<Criteria> criteria1=criteriaRepository.findById(id);
        if(criteria1.isPresent()) {
            Criteria criteria2=criteria1.get();
            criteria2.setName(criteria.getName());
            criteria2.setDescription(criteria.getDescription());
            criteria2.setWeight(criteria.getWeight());

            criteriaRepository.save(criteria2);

            return ResponseEntity.ok().body("Criteria updated successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Criteria not found");
        }
    }
}
