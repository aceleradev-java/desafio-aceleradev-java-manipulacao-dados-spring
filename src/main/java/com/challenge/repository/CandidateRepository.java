package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

public interface CandidateRepository extends CrudRepository<Candidate, Long>{

    List<Candidate> findAll();
    
    Optional<Candidate> findById(CandidateId id);
    
    List<Candidate> findAllByIdCompanyId(Long companyId);
    
    List<Candidate> findAllByIdAccelerationId(Long accelerationId);
    
}
