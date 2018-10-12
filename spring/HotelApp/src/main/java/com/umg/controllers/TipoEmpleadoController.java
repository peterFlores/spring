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

import com.umg.models.TipoEmpleado;
import com.umg.services.ITipoEmpleadoService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class TipoEmpleadoController {
	@Autowired
	public ITipoEmpleadoService service;
	
	@GetMapping("/tipoempleado")
	public List<TipoEmpleado> tipoempleado() {
		return service.findAll();
	}
	
	@PostMapping("/tipoempleado")
	@ResponseStatus(HttpStatus.CREATED)
	public TipoEmpleado agregartipoempleado(@RequestBody TipoEmpleado tipoempleado) {
		return service.save(tipoempleado);
		
	}
	
	@GetMapping("/tipoempleado/{id}")
	public TipoEmpleado show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PutMapping("/tipoempleado/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public TipoEmpleado update(@RequestBody TipoEmpleado tipoempleado, @PathVariable Long id) {
		TipoEmpleado tipoempleadoActual = service.findById(id);
		return service.save(tipoempleadoActual);
	}
	
	@DeleteMapping("/tipoempleado/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
	
}
