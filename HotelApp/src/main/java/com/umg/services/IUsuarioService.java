package com.umg.services;

import java.util.List;

import com.umg.models.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	
	public Usuario save(Usuario usuario);
	public Usuario findById(Long id);
	public void deleteById(Long id);
	
	public void update(Usuario usuario);
	
}
