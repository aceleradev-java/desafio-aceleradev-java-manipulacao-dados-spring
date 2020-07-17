package com.challenge.service.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;

@Service
public class ChallengeServiceImpl implements ChallengeServiceInterface {
    
    @Autowired
    private ChallengeRepository challengeRepository;
    
    public Challenge save(Challenge challenge) {
        return this.challengeRepository.save(challenge);
    }

    public List<Challenge> findAll() {
        return (List<Challenge>) this.challengeRepository.findAll();
    }

    @Override
    public List<Challenge> findAllByAccelerationsIdAndSubmissionsUserId(Long idAcceleration, Long userId) {
        return this.challengeRepository.findAllByAccelerationsIdAndSubmissionsIdUserId(idAcceleration, userId);
    }
}
