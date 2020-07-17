package com.challenge.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.entity.User;
import com.challenge.repository.CandidateRepository;

public class CandidateServiceImpl implements CandidateServiceInterface {

    @Autowired
    private CandidateRepository candidateRepository;
    
    @Override
    public Candidate save(Candidate object) {
        return null;
    }

    @Override
    public List<Candidate> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Candidate> findById(CandidateId id) {
        return this.candidateRepository.findById(id);
    }

    @Override
    public Optional<Candidate> findById(Long userId, Long companyId,
            Long accelerationId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Candidate> findByCompanyId(Long companyId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Candidate> findByAccelerationId(Long accelerationId) {
        // TODO Auto-generated method stub
        return null;
    }

}
