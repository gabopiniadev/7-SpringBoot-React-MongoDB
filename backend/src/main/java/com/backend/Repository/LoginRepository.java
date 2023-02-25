package com.backend.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.Models.LoginModels;

@Repository
public interface LoginRepository extends JpaRepository<LoginModels, Long>{

    LoginModels findByUsername(String username);

}
