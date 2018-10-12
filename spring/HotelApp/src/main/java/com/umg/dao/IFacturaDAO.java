package com.umg.dao;

import org.springframework.data.repository.CrudRepository;

import com.umg.models.Factura;

public interface IFacturaDAO extends CrudRepository<Factura, Long> {

}
