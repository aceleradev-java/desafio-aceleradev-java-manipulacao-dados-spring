package com.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
    
    @Autowired
    private ChallengeServiceInterface challengeService;
    
    @GetMapping
    public Iterable<Challenge> findAll() {
        return this.challengeService.findAll();
    }
    
    @PostMapping
    public Challenge save(@RequestBody Challenge challenge) {
        return this.challengeService.save(challenge);
    }
    
    @GetMapping("/findByAccelerationIdAndUserId/{idAcelleration}/{idUser}")
    public List<Challenge> findByAccelerationIdAndUserId(
            @PathVariable("idAcelleration") Long id, 
            @PathVariable("idUser") Long idUser
            ) {
        return this.challengeService.findByAccelerationIdAndUserId(id,idUser);
    }
}
