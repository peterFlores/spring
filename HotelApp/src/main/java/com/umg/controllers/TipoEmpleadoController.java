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
	
	@GetMapping("/tipo_empleado")
	public List<TipoEmpleado> tipoempleado() {
		return service.findAll();
	}
	
	@PostMapping("/tipo_empleado")
	@ResponseStatus(HttpStatus.CREATED)
	public TipoEmpleado agregarTipoEmpleado(@RequestBody TipoEmpleado tipoEmpleado) {
		return service.save(tipoEmpleado);
		
	}
	
	@GetMapping("/tipo_empleado/{id}")
	public TipoEmpleado show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PutMapping("/tipo_empleado/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public TipoEmpleado update(@RequestBody TipoEmpleado tipoEmpleado, @PathVariable Long id) {
		TipoEmpleado tipoEmpleadoActual = service.findById(id);
		tipoEmpleadoActual.setNombreTipoEmpleado(tipoEmpleado.getNombreTipoEmpleado());
		tipoEmpleadoActual.setPermisos(tipoEmpleado.getPermisos());
		
		return service.save(tipoEmpleadoActual);
	}
	
	@DeleteMapping("/tipo_empleado/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
	
}
