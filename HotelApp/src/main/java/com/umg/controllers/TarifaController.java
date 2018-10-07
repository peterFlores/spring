package com.umg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
} 
