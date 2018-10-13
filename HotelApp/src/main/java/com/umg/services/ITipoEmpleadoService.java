package com.umg.services;

import java.util.List;

import com.umg.models.TipoEmpleado;

public interface ITipoEmpleadoService {
	public List<TipoEmpleado> findAll();
	public TipoEmpleado save(TipoEmpleado tipoEmpleado);
	public TipoEmpleado findById(long id);
	public void deleteById(long id);
}
