package com.backend.Controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.backend.Models.LoginModels;
import com.backend.Services.LoginServices;

@Controller
public class LoginController {

    @Autowired
    private LoginServices loginService;

    
}
