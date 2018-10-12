package com.umg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umg.dao.ITipoEmpleadoDAO;
import com.umg.models.TipoEmpleado;

@Service
public class TipoEmpleadoImpl implements ITipoEmpleadoService{

	@Autowired
	private ITipoEmpleadoDAO tipoempleadoDao;
		
	@Override
	@Transactional(readOnly = true)
	public List<TipoEmpleado> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoEmpleado>) tipoempleadoDao.findAll();
	}

	@Override
	@Transactional
	public TipoEmpleado save(TipoEmpleado tipoempleado) {
		// TODO Auto-generated method stub
		return tipoempleadoDao.save(tipoempleado);
	}

	@Override
	@Transactional(readOnly = true)
	public TipoEmpleado findById(long id) {
		// TODO Auto-generated method stub
		return tipoempleadoDao.findById(id).orElse(null);
		
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		tipoempleadoDao.deleteById(id);
	}
	
}
