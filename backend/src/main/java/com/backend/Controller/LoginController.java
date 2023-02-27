package com.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Models.LoginModels;
import com.backend.Services.LoginServices;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginServices loginService;

    @GetMapping("/login/{username}")
	public LoginModels show(@PathVariable String username) {
		return this.loginService.loadUserByUsername(username);
	}
    
}
