package com.umg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.umg.models.Producto;
import com.umg.services.IProductoService;

@RestController
@CrossOrigin(origins = {"*"})
public class ProductoController {
	
	@Autowired
	public IProductoService service;
	
	@GetMapping("/productos")
	public List<Producto> productos() {
		return service.findAll();
	}
	
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto agregarProducto(@RequestBody Producto producto) {
		return service.save(producto);
		
	}
	
	
	@PutMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto producto, @PathVariable Long id) {
		Producto productoActual = service.findById(id);
		productoActual.setProducto(producto.getProducto());
		productoActual.setCosto(producto.getCosto());
		
		return service.save(productoActual);
	}
	
	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
}
