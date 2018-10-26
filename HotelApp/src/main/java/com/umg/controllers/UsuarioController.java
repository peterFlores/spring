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

import com.umg.models.Usuario;
import com.umg.services.IUsuarioService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;

	@GetMapping("/usuarios")
	public List<Usuario> listar() {
		return service.findAll();
	}
	
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public void agregarUsuario(@RequestBody Usuario usuario) {
		service.save(usuario);
		
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario show(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		usuario.setIdUsuario(id);
		return service.save(usuario);
	}
	
	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
}
