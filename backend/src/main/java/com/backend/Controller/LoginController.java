package com.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Models.LoginModels;
import com.backend.Services.LoginServices;
import org.springframework.http.HttpStatus;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginServices loginService;

    //Encargado de obtener la informacion del usuario mediante el username
    @GetMapping("/log/{username}")
	public LoginModels show(@PathVariable String username) {
		return this.loginService.loadUserByUsername(username);
	}

    //Esta funcion se encarga de obtener el/los resultados mediante el id del mismo
	@GetMapping("/login/{id}")
	public LoginModels show(@PathVariable Long id) {
		return this.loginService.findById(id);
	}

    //Esta funcion se encarga de obtener todos los resultados almacenados en la base de datos.
	@GetMapping("/logins")
	public List<LoginModels> index() {
		return loginService.findAll();
	}
	
	//Esta funcion permite crear o insertar informacion a la base de datos.
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.CREATED)
	public LoginModels create(@RequestBody LoginModels logins) {
		this.loginService.save(logins);
		return logins;
	}
	
	//Esta funcion se encarga de modificar algun resultado segun el filtro, ejemplo UPDATE persona SET nombre = "Ale" WHERE id = 1 
	@PutMapping("/login/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public LoginModels update(@RequestBody LoginModels logins, @PathVariable Long id) {
		LoginModels login = this.loginService.findById(id);
		login.setUsername(logins.getUsername());
		login.setPassword(logins.getPassword());
		this.loginService.save(login);
		return login;
	}
	
	//Esta funcion nos permite eliminar un registro de nuestra base de datos, filtrando por el ID.
	@DeleteMapping("/login/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		LoginModels login = this.loginService.findById(id);
		this.loginService.delete(login);
	}
    
}
