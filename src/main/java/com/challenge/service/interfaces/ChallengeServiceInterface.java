package com.challenge.service.interfaces;

import java.util.List;

import com.challenge.entity.Challenge;

public interface ChallengeServiceInterface extends ServiceInterface<Challenge> {
    
    List<Challenge> findAll();
   
    List<Challenge> findByAccelerationIdAndUserId(Long idAcceleration, Long userId);
    
    Challenge save(Challenge challenge);
}
