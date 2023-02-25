package com.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.backend.Models.LoginModels;
import com.backend.Services.LoginServices;


@CrossOrigin(origins = { "http://localhost:3000" })
@RequestMapping("/api")
@RestController
public class LoginController {

    @Autowired
    private LoginServices loginService;

    @GetMapping("/login/{username}")
	public LoginModels show(@PathVariable String username) {
		return loginService.loadUserByUsername(username);
	}

    
}
