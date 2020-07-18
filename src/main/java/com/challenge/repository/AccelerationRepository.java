package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.challenge.entity.Acceleration;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {
    
    List<Acceleration> findAll();
    
    Optional<Acceleration> findById(Long id);
    
    Optional<Acceleration> findByName(String name);
    
    List<Acceleration> findByCandidatesIdCompanyId(Long companyId);
    
}
