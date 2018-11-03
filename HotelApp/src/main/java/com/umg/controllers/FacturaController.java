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
import com.umg.models.ItemFactura;
import com.umg.services.IFacturaService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class FacturaController {
	@Autowired
	public IFacturaService service;
	
	
	
	@GetMapping("/factura/{id}")
	public List<Factura> showByHuesped(@PathVariable Long id) {
		System.out.println("entro");
		return service.findAllByHuesped(id);
	}
	
	@PostMapping("/factura/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void addFactura(@RequestBody Factura fact, @PathVariable Long id) {
		service.saveByHuesped(fact, id);
	}
	
	
}
