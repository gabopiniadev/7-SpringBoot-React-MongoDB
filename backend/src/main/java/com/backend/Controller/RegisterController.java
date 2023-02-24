package com.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.backend.Models.RegisterModels;
import com.backend.Services.RegisterServices;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/api")
public class RegisterController {

    @Autowired
    private RegisterServices registerService;

    @PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public RegisterModels create(@RequestBody RegisterModels register) {
		this.registerService.save(register);
		return register;
	}
    
}
