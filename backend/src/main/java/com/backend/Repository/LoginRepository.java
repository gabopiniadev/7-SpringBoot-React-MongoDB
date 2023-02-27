package com.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Models.LoginModels;

public interface LoginRepository extends JpaRepository<LoginModels, Long>{

    
    LoginModels findByUsername(String username);
    
}
