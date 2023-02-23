package com.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Models.PostModels;
import com.backend.Services.PostServices;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostServices postService;

    //Esta funcion nos permite ejecutar una carga masiva de un API externo y almacenarla en nuestra base de datos
	@GetMapping("/carga")
	public String carga() {
		return productsService.saveList();
	}
	
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
	@PostMapping("/products")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductsModels create(@RequestBody ProductsModels products) {
		this.productsService.save(products);
		return products;
	}
	
	//Esta funcion se encarga de modificar algun resultado segun el filtro, ejemplo UPDATE persona SET nombre = "Ale" WHERE id = 1 
	@PutMapping("/products/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductsModels update(@RequestBody ProductsModels products, @PathVariable Long id) {
		ProductsModels currentProducts = this.productsService.findById(id);
		currentProducts.setTitle(products.getTitle());
		currentProducts.setPrice(products.getPrice());
		currentProducts.setDescription(products.getDescription());
		currentProducts.setCategory(products.getCategory());
		currentProducts.setImage(products.getImage());
		this.productsService.save(currentProducts);
		return currentProducts;
	}
	
	//Esta funcion nos permite eliminar un registro de nuestra base de datos, filtrando por el ID.
	@DeleteMapping("/article/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		ProductsModels currentProducts = this.productsService.findById(id);
		this.productsService.delete(currentProducts);
	}
    
    
}
