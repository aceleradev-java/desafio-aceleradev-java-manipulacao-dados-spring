package com.challenge.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyServiceInterface {
    
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company save(Company company) {
        return this.companyRepository.save(company);
    }

    @Override
    public List<Company> findAll() {
        return this.companyRepository.findAll();
    }

    @Override
    public Optional<Company> findById(Long id) {
        return this.companyRepository.findById(id);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        return this.companyRepository.findDistinctByCandidatesIdAccelerationId(accelerationId);
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        return this.companyRepository.findAllByCandidatesIdUserId(userId);
    }

}
