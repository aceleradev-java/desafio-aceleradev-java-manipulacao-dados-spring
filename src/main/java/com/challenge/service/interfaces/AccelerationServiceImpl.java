package com.challenge.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Acceleration;
import com.challenge.repository.AccelerationRepository;

@Service
public class AccelerationServiceImpl implements AccelerationServiceInterface {
    
    @Autowired
    private AccelerationRepository accelerationRepository;
    

    @Override
    public Acceleration save(Acceleration acceleration) {
        return this.accelerationRepository.save(acceleration);
    }

    @Override
    public List<Acceleration> findAll() {
        return this.accelerationRepository.findAll();
    }

    @Override
    public Optional<Acceleration> findById(Long id) {
        return this.accelerationRepository.findById(id);
    }

    @Override
    public List<Acceleration> findByCompanyId(Long companyId) {
        return this.accelerationRepository.findByCandidatesIdCompanyId(companyId);
    }

    @Override
    public Optional<Acceleration> findByName(String name) {
        return this.accelerationRepository.findByName(name);
    }

}
