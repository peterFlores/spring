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

import com.umg.models.Factura;
import com.umg.services.IFacturaService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class FacturaController {
	@Autowired
	public IFacturaService service;
	
	@GetMapping("/factura")
	public List<Factura> factura() {
		return service.findAll();
	}
	
	@PostMapping("/factura")
	@ResponseStatus(HttpStatus.CREATED)
	public Factura agregarFactura(@RequestBody Factura factura) {
		return service.save(factura);	
	}
	@GetMapping("/factura/{id}")
	public Factura show(@PathVariable Long id) {
		return service.findById(id);
	}
	@PutMapping("/factura/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Factura update(@RequestBody Factura factura, @PathVariable Long id) {
		Factura FacturaActual = service.findById(id);
		return service.save(FacturaActual);
	}
	@DeleteMapping("/factura/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
	
}
