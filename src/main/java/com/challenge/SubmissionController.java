package com.challenge;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {
    
    @Autowired
    private SubmissionServiceInterface submissionService;
    
    @Autowired
    private SubmissionRepository repo;
    
    @GetMapping
    public List<Submission> findAll() {
        return this.submissionService.findAll();
    }
    
    @GetMapping("/findByChallengeIdAndAccelerationId/{challengeId}/{accelerationId}")
    public List<Submission> findByChallengeIdAndAccelerationId(@PathVariable("challengeId") Long challengeId,
            @PathVariable("accelerationId") Long accelerationId){
        return this.submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }
    
    @GetMapping("/findHigherScoreByChallengeId/{challengeId}")
    public BigDecimal findHigherScoreByChallengeId(@PathVariable("challengeId") Long challengeId){
        return this.submissionService.findHigherScoreByChallengeId(challengeId);
    }
    
    @PostMapping
    public Submission save(@RequestBody Submission submission) {
        return this.submissionService.save(submission);
    }
    
}
