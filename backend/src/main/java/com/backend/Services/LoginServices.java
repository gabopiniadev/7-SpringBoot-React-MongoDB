package com.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.Models.LoginModels;
import com.backend.Repository.LoginRepository;

@Service
public class LoginServices{

    @Autowired
    private LoginRepository loginRepository;

    public LoginModels loadUserByUsername(String username) {
       
        return loginRepository.findByUsername(username);
        

    }

    public Iterable<LoginModels> listAll() {
        return this.loginRepository.findAll();
    }

    public void save(LoginModels username) {
		loginRepository.save(username);
	}

	public LoginModels findById(Long id) {
		return loginRepository.findById(id).orElse(null);
	}

	public void delete(LoginModels username) {
		loginRepository.delete(username);
	}   
    
}
