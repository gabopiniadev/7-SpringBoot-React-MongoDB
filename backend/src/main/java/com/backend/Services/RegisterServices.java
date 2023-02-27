package com.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.Models.RegisterModels;
import com.backend.Repository.RegisterRepository;

@Service
public class RegisterServices {

    @Autowired 
    RegisterRepository registerRepository;

    public void save(RegisterModels users) {
		registerRepository.save(users);
	}

}
