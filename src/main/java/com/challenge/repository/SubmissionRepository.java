package com.challenge.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;

public interface SubmissionRepository extends CrudRepository<Submission , SubmissionId> {
    List<Submission> findAll();
    
    @Query(value = "select * from submission sub " +
            "INNER JOIN challenge ch " +
            "ON sub.challenge_id  = ch.id " +
            "INNER JOIN acceleration acc " +
            "ON ch.id = acc.challenge_id " +
            "where ch.id = :challengeId and acc.id = :accelerationId ", nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);
    
    @Query(value = "select MAX(sub.score) from submission sub " +
            "where sub.challenge_id = :challengeId ", nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);
    
    Submission findFirstByIdChallengeIdOrderByScoreDesc(Long id);
}
