package com.umg.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.umg.dao.IUsuarioDAO;
import com.umg.models.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioDAO service;

	
	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) service.findAll();
	}


	@Override
	public Usuario save(Usuario usuario) {
		return service.save(usuario);
		
	}

	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return service.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		service.deleteById(id);
		
	}


	@Override
	public void update(Usuario usuario) {
	}

}
