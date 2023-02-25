package com.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.backend.Models.RegisterModels;
import com.backend.Services.RegisterServices;

@CrossOrigin(origins = { "http://localhost:3000" })
@RequestMapping("/api")
@RestController
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
