package com.umg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umg.dao.IProductoDAO;
import com.umg.models.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoDAO service;

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>) service.findAll();
	}

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return service.save(producto);
	}

	@Override
	public Producto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		service.deleteById(id);
		
	}
}
