package com.umg.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umg.models.ItemFactura;

@Service
public class ItemFacturaServiceImpl implements IFacturaItemService {

	
	
	@Autowired
	private JdbcTemplate service;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<ItemFactura> findAll() {
		String sql = "SELECT * FROM itemfact";
		// TODO Auto-generated method stub
		return service.query(sql, new RowMapper<ItemFactura>() {

			@Override
			public ItemFactura mapRow(ResultSet rs, int rowNum) throws SQLException {
				ItemFactura item = new ItemFactura();
				item.setIdItem(rs.getLong("itemID"));
				item.setCantidad(rs.getInt("cantidad"));
				item.setTotal(rs.getDouble("total"));
				item.setIdProducto(rs.getInt("idProducto"));
				return item;
			}
		});
	}

	@Override
	@Transactional
	public ItemFactura save(ItemFactura itemfactura) {
		return null;
		
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		
	}

	@Override
	@Transactional(readOnly=true)
	public ItemFactura findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
