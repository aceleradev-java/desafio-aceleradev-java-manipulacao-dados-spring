package com.challenge.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

public interface CandidateRepository extends CrudRepository<Candidate, Long>{
    Optional<Candidate> findById(CandidateId id);
}
