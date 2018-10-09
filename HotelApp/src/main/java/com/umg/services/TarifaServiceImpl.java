package com.umg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umg.dao.ITarifaDAO;
import com.umg.models.Tarifa;

@Service
public class TarifaServiceImpl implements ITarifaService {

	@Autowired
	private ITarifaDAO tarifaDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Tarifa> findAll() {
		// TODO Auto-generated method stub
		return (List<Tarifa>) tarifaDao.findAll();
	}

	@Override
	@Transactional
	public Tarifa save(Tarifa tarifa) {
		return tarifaDao.save(tarifa);
		
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		tarifaDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Tarifa findById(Long id) {
		// TODO Auto-generated method stub
		return tarifaDao.findById(id).orElse(null);
	}

}
