package com.challenge;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Company;
import com.challenge.service.interfaces.CompanyServiceInterface;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {
    
    @Autowired
    private CompanyServiceInterface companyService;
    
    @GetMapping
    public List<Company> findAll() {
        return this.companyService.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Company> getById(@PathVariable("id") Long id) {
        return this.companyService.findById(id);
    }

    @GetMapping("/findbyAccelerationId/{accelarationId}")
    public List<Company> findbyAccelerationId(@PathVariable(name = "accelarationId") Long accelerationId) {
        return this.companyService.findByAccelerationId(accelerationId);
    }
    
    @GetMapping("/findByUserId/{userId}")
    public List<Company> findByUserId(@PathVariable(name = "userId") Long userId) {
        return this.companyService.findByUserId(userId);
    }
    
    @PostMapping
    public Company save(@RequestBody Company company) {
        return this.companyService.save(company);
    }
}
