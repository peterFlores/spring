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

import com.umg.models.Huesped;
import com.umg.services.IHuespedService;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class HuespedController {
	@Autowired
	public IHuespedService service;
	@GetMapping("/huespeds")
	public List<Huesped> huespeds() {
		return service.findAll();
	}
	
	@PostMapping("/huespeds")
	@ResponseStatus(HttpStatus.CREATED)
	public Huesped agregarHuesped(@RequestBody Huesped huesped) {
		return service.save(huesped);
		
	}
	
	@GetMapping("/huespeds/{id}")
	public Huesped show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PutMapping("/huespeds/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Huesped update(@RequestBody Huesped huesped, @PathVariable Long id) {
		Huesped huespedActual = service.findById(id);
		huespedActual.setNombre(huesped.getNombre());
		huespedActual.setApellido(huesped.getApellido());
		huespedActual.setDireccion(huesped.getDireccion());
		huespedActual.setEdad(huesped.getEdad());
		huespedActual.setGenero(huesped.getGenero());
		huespedActual.setTelefono(huesped.getTelefono());
		huespedActual.setDpi(huesped.getDpi());
		return service.save(huespedActual);
	}
	
	@DeleteMapping("/huespeds/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
} 


