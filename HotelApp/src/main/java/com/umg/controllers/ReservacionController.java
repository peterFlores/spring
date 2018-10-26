package com.umg.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umg.models.Reservacion;
import com.umg.services.IRoomService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class ReservacionController {
	
	@Autowired
	private IRoomService service;

	
	@GetMapping("/reservaciones")
	public List<Reservacion> listar() {
		return service.findAllReservations();
	}
}
