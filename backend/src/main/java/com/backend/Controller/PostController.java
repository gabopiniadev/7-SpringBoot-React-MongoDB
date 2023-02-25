package com.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.backend.Models.PostModels;
import com.backend.Services.PostServices;

@CrossOrigin(origins = { "http://localhost:3000" })
@RequestMapping("/api")
@RestController
public class PostController {

    @Autowired
    private PostServices postService;

	//Esta funcion se encarga de obtener todos los resultados almacenados en la base de datos.
	@GetMapping("/articles")
	public List<PostModels> index() {
		return postService.findAll();
	}
	
	//Esta funcion se encarga de obtener el/los resultados mediante el id del mismo
	@GetMapping("/article/{id}")
	public PostModels show(@PathVariable Long id) {
		return this.postService.findById(id);
	}
	
	//Esta funcion permite crear o insertar informacion a la base de datos.
	@PostMapping("/article")
	@ResponseStatus(HttpStatus.CREATED)
	public PostModels create(@RequestBody PostModels post) {
		this.postService.save(post);
		return post;
	}
	
	//Esta funcion se encarga de modificar algun resultado segun el filtro, ejemplo UPDATE persona SET nombre = "Ale" WHERE id = 1 
	@PutMapping("/article/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public PostModels update(@RequestBody PostModels post, @PathVariable Long id) {
		PostModels articles = this.postService.findById(id);
		articles.setUsername(post.getUsername());
		articles.setNombre(post.getNombre()); //Titulo del articulo!
		articles.setContenido(post.getContenido());
		articles.setImagen(post.getImagen());
		this.postService.save(articles);
		return articles;
	}
	
	//Esta funcion nos permite eliminar un registro de nuestra base de datos, filtrando por el ID.
	@DeleteMapping("/article/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		PostModels articles = this.postService.findById(id);
		this.postService.delete(articles);
	}
    
    
}
