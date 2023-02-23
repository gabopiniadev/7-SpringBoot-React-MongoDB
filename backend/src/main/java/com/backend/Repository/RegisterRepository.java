package com.backend.Repository;

import org.springframework.data.repository.CrudRepository;

import com.backend.Models.RegisterModels;

public interface RegisterRepository extends CrudRepository<RegisterModels, Long> {
    
}
