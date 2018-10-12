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

import com.umg.models.ItemFactura;
import com.umg.services.IFacturaItemService;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class FacturaItemController {
	@Autowired
	public IFacturaItemService service;
	

	@GetMapping("/Itemfac")
	public List<ItemFactura> Itemfac() {
		return service.findAll();
	}
	
	@PostMapping("/Itemfac")
	@ResponseStatus(HttpStatus.CREATED)
	public ItemFactura agregarItemfactura(@RequestBody ItemFactura itemfactura) {
		return service.save(itemfactura);
		
	}
	
	@GetMapping("/Itemfac/{id}")
	public ItemFactura show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PutMapping("/Itemfac/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ItemFactura update(@RequestBody ItemFactura itemfactura, @PathVariable Long id) {
		ItemFactura itemActual = service.findById(id);
		itemActual.setItem(itemfactura.getItem());
		itemActual.setCosto(itemfactura.getCosto());
		
		return service.save(itemActual);
	}
	
	@DeleteMapping("/Itemfac/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
}
