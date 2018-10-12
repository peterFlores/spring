package com.umg.services;

import java.util.List;

import com.umg.models.Tarifa;

public interface ITarifaService {

	public List<Tarifa> findAll();
	
	public Tarifa save(Tarifa tarifa);
	
	public Tarifa findById(Long id);
	
	public void deleteById(Long id);
}
