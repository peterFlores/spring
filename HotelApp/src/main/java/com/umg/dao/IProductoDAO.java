package com.umg.dao;

import org.springframework.data.repository.CrudRepository;

import com.umg.models.Producto;

public interface IProductoDAO extends CrudRepository<Producto, Long>{

}
