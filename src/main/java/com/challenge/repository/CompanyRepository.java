package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.challenge.entity.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    
    List<Company> findAll();
    
    Optional<Company> findById(Long id);
    
    List<Company> findDistinctByCandidatesIdAccelerationId(Long accelarationId);
    
    List<Company> findAllByCandidatesIdUserId(Long userId);
}
