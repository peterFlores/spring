package com.umg.dao;
import org.springframework.data.repository.CrudRepository;

import com.umg.models.ItemFactura;

public interface FacturaItemDAO extends CrudRepository<ItemFactura, Long> {

}
