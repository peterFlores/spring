package com.umg.services;

import java.util.List;

import com.umg.models.Factura;

public interface IFacturaService {
	public List<Factura> findAll();
	public Factura save(Factura factura);
	public void saveByHuesped(Factura factura, Long id);
	public Factura findById(Long id);
	public void deleteById(Long id);
	public List<Factura> findAllByHuesped(Long id);
}
