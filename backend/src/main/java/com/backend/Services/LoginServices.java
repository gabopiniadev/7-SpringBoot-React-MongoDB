package com.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Models.LoginModels;
import com.backend.Repository.LoginRepository;

@Service
public class LoginServices {

    @Autowired
    private LoginRepository loginRepository;

    public LoginModels login(String username, String password) {
        LoginModels user = loginRepository.findByUsernameAndPassword(username, password);
        return user;
    }
    
}
