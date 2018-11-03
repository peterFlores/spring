package com.umg.services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umg.models.Factura;
import com.umg.models.ItemFactura;
import com.umg.models.Reservacion;


@Service
public class FacturaServiceImpl implements IFacturaService {
	
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional(readOnly = true)
	public List<Factura> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Factura save(Factura factura) {
		return null;
		
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
	}

	@Override
	@Transactional(readOnly=true)
	public Factura findById(Long id) {
		
		return null;
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

	@Override
	@Transactional
	public void saveByHuesped(Factura factura, Long id) {
		String sqlFactura = "INSERT INTO factura (serie, numfact, total) VALUES ('FACE-3B90', ?, ?)";
		KeyHolder facturaHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sqlFactura, java.sql.Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, generateNumFact(id));
				ps.setFloat(2, factura.getTotal());
				return ps;
			}
		}, facturaHolder);
		int facturaID = facturaHolder.getKey().intValue();
		String sql = "INSERT INTO itemfact (cantidad, total, idProducto) VALUES (?,?,?)";
		String sqlfDTO = "INSERT INTO facturadto (facturaID, itemID) VALUES (?,?)";
		for (ItemFactura items : factura.getItems()) {
			KeyHolder itemHolder = new GeneratedKeyHolder();

			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					ps.setInt(1, items.getCantidad());
					ps.setDouble(2, items.getTotal());
					ps.setInt(3, items.getIdProducto());
					return ps;
				}
			}, itemHolder);
			
			int itemID = itemHolder.getKey().intValue();
			jdbcTemplate.update(sqlfDTO, new Object[] { facturaID, itemID });
		}
		
		String sqlHDTO = "INSERT INTO huespeddto (huespedID, facturaID) VALUES (?,?)";
		jdbcTemplate.update(sqlHDTO, new Object[] {id, facturaID});
		
	}
	
	private String generateNumFact(Long id) {
		StringBuilder bld = new StringBuilder();
		bld.append(id).append(new SimpleDateFormat("yyyyMMdd").format(new Date().getTime()));
		return bld.toString();
	}

}
