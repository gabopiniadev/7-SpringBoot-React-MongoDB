package com.backend.Repository;

import org.springframework.data.repository.CrudRepository;
import com.backend.Models.LoginModels;

public interface LoginRepository extends CrudRepository<LoginModels, Long>{

    LoginModels findByUsername(String username);
    
}
