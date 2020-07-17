package com.challenge.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.challenge.entity.Challenge;

public interface ChallengeRepository extends CrudRepository<Challenge, Long>{
    
    List<Challenge> findAllByAccelerationsIdAndSubmissionsIdUserId(Long idAcceleration, Long userId);
    List<Challenge> findAll();
}
