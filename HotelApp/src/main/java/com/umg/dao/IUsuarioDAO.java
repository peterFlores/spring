package com.umg.dao;

import org.springframework.data.repository.CrudRepository;

import com.umg.models.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{

}
