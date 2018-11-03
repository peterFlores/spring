package com.umg.services;

import java.util.List;

import com.umg.models.Producto;


public interface IProductoService {

	public List<Producto> findAll();
	
	public Producto save(Producto producto);
	
	public Producto findById(Long id);
	
	public void deleteById(Long id);
}
