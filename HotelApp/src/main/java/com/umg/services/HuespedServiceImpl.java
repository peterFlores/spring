package com.umg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umg.dao.IHuespedDAO;
import com.umg.models.Huesped;

@Service
public class HuespedServiceImpl implements IHuespedService {
	
	@Autowired
	private IHuespedDAO huespedDao;

	@Override
	@Transactional(readOnly = true)
	public List<Huesped> findAll() {
		// TODO Auto-generated method stub
		return (List<Huesped>) huespedDao.findAll();
	}

	@Override
	@Transactional
	public Huesped save(Huesped huesped) {
		return huespedDao.save(huesped);
		
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		huespedDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Huesped findById(Long id) {
		// TODO Auto-generated method stub
		return huespedDao.findById(id).orElse(null);
	}


}
