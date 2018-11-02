package com.umg.services;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umg.dao.IFacturaDAO;

import com.umg.models.Factura;


@Service
public class FacturaServiceImpl implements IFacturaService {
	
	@Autowired
	private IFacturaDAO facturaDao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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

	@Override
	public List<Factura> findAllByHuesped(Long id) {
		String sql = "SELECT f.facturaID, f.serie, f.numfact, f.total "
				+ "FROM huesped h INNER JOIN huespeddto ht "
				+ "ON h.huespedID = ht.huespedID INNER JOIN factura f ON ht.facturaID = f.facturaID"
				+ " WHERE ht.huespedID = ? ";
		
		return jdbcTemplate.query(sql, new Object[] {id}, new RowMapper<Factura>() {

			@Override
			public Factura mapRow(ResultSet rs, int rowNum) throws SQLException {
				Factura fact = new Factura();
				fact.setIdFactura(rs.getLong("facturaID"));
				fact.setSerie(rs.getString("serie"));
				fact.setNumfact(rs.getString("numfact"));
				fact.setTotal(rs.getFloat("total"));
				// TODO Auto-generated method stub
				return fact;
			}
		});
	}

}
