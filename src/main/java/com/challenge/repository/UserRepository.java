package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.challenge.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
    Optional<User> getById(Long id);
    
    @Query(value = "select * from users u " +
            "INNER JOIN candidate c " +
            "ON u.id = c.user_id " +
            "INNER JOIN acceleration a " +
            "ON a.id = c.acceleration_id " +
            "where a.name like %:name%", nativeQuery = true)
    List<User> findByAccelerationName(@Param("name") String name);
    
    @Query(value = "select * from users u " +
            "INNER JOIN candidate c " +
            "ON u.id = c.user_id " +
            "INNER JOIN acceleration a " +
            "ON a.id = c.acceleration_id " +
            "where c.company_id = :idCompany", nativeQuery = true)
    List<User> findByCompanyId(@Param("idCompany") Long id);
    
}
