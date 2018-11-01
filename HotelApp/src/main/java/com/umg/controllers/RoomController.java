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

import com.umg.dao.IRoomDAO;
import com.umg.models.Reservacion;
import com.umg.models.Room;
import com.umg.models.Tarifa;
import com.umg.services.IRoomService;
import com.umg.services.ITarifaService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class RoomController {

	@Autowired
	private ITarifaService tarifaService;
	
	@Autowired
	private IRoomService service;

	
	@GetMapping("/rooms")
	public List<Room> listar() {
		return service.findAll();
	}
	
	@GetMapping("/rooms/availables")
	public List<Room> listarAvailable() {
		return service.findAllByStatus();
	}
	
	@PostMapping("/rooms/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Room agregarRoom(@PathVariable(value = "id") Long id, @RequestBody Room room) {
		Tarifa tarifa = tarifaService.findById(id);
		room.setTarifa(tarifa);
		return service.save(room);
		
	}
	
	@GetMapping("/rooms/{id}")
	public Room show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PutMapping("/rooms/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Room update(@RequestBody Room room, @PathVariable(value = "id") Long id) {
		//Tarifa tarifa = tarifaService.findById(tarifaId);
		
			if (service.findById(id) != null) {
				room.setIdRoom(id);
				return service.save(room);
			}
		
		return null;
	}
	
	@DeleteMapping("/rooms/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
	

}
