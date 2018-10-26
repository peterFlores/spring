package com.umg.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umg.dao.IRoomDAO;
import com.umg.models.Factura;
import com.umg.models.Huesped;
import com.umg.models.Reservacion;
import com.umg.models.Room;

@Service
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private IRoomDAO roomService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional(readOnly=true)
	public List<Room> findAll() {
		// TODO Auto-generated method stub
		return (List<Room>) roomService.findAll();
	}

	@Override
	public Room save(Room room) {
		// TODO Auto-generated method stub
		return roomService.save(room);
	}

	@Override
	public Room findById(Long id) {
		// TODO Auto-generated method stub
		return roomService.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		roomService.deleteById(id);
		
	}

	@Override
	public void update(Room room) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Reservacion> findAllReservations() {
		String sql = "SELECT h.nombre, h.apellido, r.room, r.checkin, r.checkout from huesped h "
				+ "INNER JOIN huespeddto ht on h.huespedID = ht.huespedID " + 
				"inner JOIN room r on ht.roomID = r.roomID";
		
		return jdbcTemplate.query(sql, new RowMapper<Reservacion>() {

			@Override
			public Reservacion mapRow(ResultSet rs, int rowNum) throws SQLException {
				Reservacion reservacion = new Reservacion();
				Huesped huesped = new Huesped();
				Factura factura = new Factura();
				Room room = new Room();
				huesped.setNombre(rs.getString("nombre"));
				huesped.setApellido(rs.getString("apellido"));
				room.setRoom(rs.getString("room"));
				room.setCheckIn(rs.getDate("checkin"));
				room.setCheckOut(rs.getDate("checkout"));
				reservacion.setHuesped(huesped);
				reservacion.setRoom(room);
				reservacion.setFactura(factura);
				return reservacion;
			}
		});
	}

	
}
