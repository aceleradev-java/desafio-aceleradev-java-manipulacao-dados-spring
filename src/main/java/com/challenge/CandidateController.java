package com.challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Candidate;
import com.challenge.service.interfaces.CandidateServiceInterface;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateServiceInterface candidateService;
    
    @GetMapping
    public List<Candidate> findAll() {
        return this.candidateService.findAll();
    }
    
    @PostMapping
    public Candidate save(@RequestBody Candidate candidate) {
        return this.candidateService.save(candidate);
    }
    
    @GetMapping("/findByCompanyId/{companyId}")
    public List<Candidate> findByCompanyId(@PathVariable("companyId") Long companyId) {
        return this.candidateService.findByCompanyId(companyId);
    }
    
    @GetMapping("/findByAccelerationId/{accelerationId}")
    public List<Candidate> findByAccelerationId(@PathVariable("accelerationId") Long accelerationId) {
        return this.candidateService.findByAccelerationId(accelerationId);
    }
}
