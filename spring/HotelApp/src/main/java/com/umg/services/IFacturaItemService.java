package com.umg.services;

import java.util.List;

import com.umg.models.ItemFactura;

public interface IFacturaItemService {

public List<ItemFactura> findAll();
	
	public ItemFactura save(ItemFactura itemfactura);
	
	public ItemFactura findById(Long id);
	
	public void deleteById(Long id);
}
