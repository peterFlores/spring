package com.umg.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umg.dao.IFacturaDAO;

import com.umg.models.Factura;


@Service
public class FacturaServiceImpl implements IFacturaService {
	
	@Autowired
	private IFacturaDAO facturaDao;
	

	@Override
	@Transactional(readOnly = true)
	public List<Factura> findAll() {
		// TODO Auto-generated method stub
		return (List<Factura>) facturaDao.findAll();
	}

	@Override
	@Transactional
	public Factura save(Factura factura) {
		return facturaDao.save(factura);
		
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		facturaDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Factura findById(Long id) {
		
		return facturaDao.findById(id).orElse(null);
	}

}
