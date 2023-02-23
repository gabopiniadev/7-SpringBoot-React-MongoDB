package com.backend.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.backend.Models.LoginModels;

public interface LoginRepository extends CrudRepository<LoginModels, String>{

    @Query("SELECT username, password FROM users WHERE username = :username AND password = :password")
    public LoginModels findByUsernameAndPassword(String username, String password); 
    
}
