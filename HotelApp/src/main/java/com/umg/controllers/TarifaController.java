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

import com.umg.models.Tarifa;
import com.umg.services.ITarifaService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class TarifaController {

	@Autowired
	public ITarifaService service;
	
	@GetMapping("/tarifas")
	public List<Tarifa> tarifas() {
		return service.findAll();
	}
	
	@PostMapping("/tarifas")
	@ResponseStatus(HttpStatus.CREATED)
	public Tarifa agregarTarifa(@RequestBody Tarifa tarifa) {
		return service.save(tarifa);
		
	}
	
	@GetMapping("/tarifas/{id}")
	public Tarifa show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PutMapping("/tarifas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Tarifa update(@RequestBody Tarifa tarifa, @PathVariable Long id) {
		Tarifa tarifaActual = service.findById(id);
		return service.save(tarifaActual);
	}
	
	@DeleteMapping("/tarifas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
} 
