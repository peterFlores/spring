package com.umg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umg.dao.FacturaItemDAO;
import com.umg.models.ItemFactura;

@Service
public class ItemFacturaServiceImpl implements IFacturaItemService {

	@Autowired
	private FacturaItemDAO itemfacturaDAO;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<ItemFactura> findAll() {
		// TODO Auto-generated method stub
		return (List<ItemFactura>) itemfacturaDAO.findAll();
	}

	@Override
	@Transactional
	public ItemFactura save(ItemFactura itemfactura) {
		return itemfacturaDAO.save(itemfactura);
		
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		itemfacturaDAO.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public ItemFactura findById(Long id) {
		// TODO Auto-generated method stub
		return itemfacturaDAO.findById(id).orElse(null);
	}
}
