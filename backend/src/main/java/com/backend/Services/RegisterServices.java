package com.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.Models.RegisterModels;
import com.backend.Repository.RegisterRepository;

@Service
public class RegisterServices {

    @Autowired 
    RegisterRepository registerRepository;

    public Iterable<RegisterModels> listAll() {
        return this.registerRepository.findAll();
    }

    public void save(RegisterModels users) {
		registerRepository.save(users);
	}

	public RegisterModels findById(Long id) {
		return registerRepository.findById(id).orElse(null);
	}

	public void delete(RegisterModels users) {
		registerRepository.delete(users);
	}   
}
