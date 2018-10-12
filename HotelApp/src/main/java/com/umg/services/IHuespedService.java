package com.umg.services;

import java.util.List;

import com.umg.models.Huesped;

public interface IHuespedService {
	public List<Huesped> findAll();
	public Huesped save(Huesped huesped);
	public Huesped findById(Long id);
	public void deleteById(Long id);
}
