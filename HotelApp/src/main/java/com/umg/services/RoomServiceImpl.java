package com.umg.services;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
	@Transactional
	public Room save(Room room) {
		// TODO Auto-generated method stub
		return roomService.save(room);
	}

	@Override
	@Transactional(readOnly=true)
	public Room findById(Long id) {
		// TODO Auto-generated method stub
		return roomService.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		roomService.deleteById(id);
		
	}

	@Override
	public void update(Room room) {
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional(readOnly=true)
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

	@Override
	@Transactional(readOnly=true)
	public List<Room> findAllByStatus() {
		return (List<Room>) roomService.findAllByStatus();
	}

	@Override
	@Transactional
	public void insertReservation(Reservacion reservation) {
		// TODO Auto-generated method stub
		String sqlProducto = "INSERT INTO producto (producto, costo) VALUES (?, ?)";
		String sqlItemFact = "INSERT INTO itemfact (cantidad, total, idProducto) VALUES (?, ?, ?)";
		String sqlFact = "INSERT INTO factura (serie, numfact, total) VALUES ('FACE-3B90', ?, ?)";
		String sqlFactDTO = "INSERT INTO facturadto (facturaID, itemID) VALUES (?,?)";
		String sqlHuespedDTO = "INSERT INTO huespeddto (huespedID, roomID, facturaID) VALUES (?,?,?)";
		String sqlRoomUpdate = "UPDATE room SET checkin = ?, checkout = ?, status = 'O' WHERE roomID = ?";
		
		jdbcTemplate.update(sqlRoomUpdate, new Object[] {reservation.getRoom().getCheckIn(), 
					reservation.getRoom().getCheckOut(), 
					reservation.getRoom().getIdRoom()});
		
		KeyHolder productoHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sqlProducto, java.sql.Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, reservation.getRoom().getRoom());
				ps.setDouble(2, reservation.getRoom().getTarifa().getCosto());
				return ps;
			}
		}, productoHolder);
		
		int productoID = productoHolder.getKey().intValue();
		
		KeyHolder itemHolder = new GeneratedKeyHolder();
		int qty = daysBetweenUsingJoda(reservation.getRoom().getCheckIn(), reservation.getRoom().getCheckOut());
		float total = (float) (qty * reservation.getRoom().getTarifa().getCosto());
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sqlItemFact, java.sql.Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, qty);
				ps.setFloat(2, total);
				ps.setInt(3, productoID);
				return ps;
			}
		}, itemHolder);
		
		int itemID = itemHolder.getKey().intValue();
		
		KeyHolder factHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sqlFact, java.sql.Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, generateNumFact(reservation));
				ps.setFloat(2, total);
				return ps;
			}
		}, factHolder);
		int facturaID = factHolder.getKey().intValue();
		jdbcTemplate.update(sqlFactDTO, new Object[] {facturaID, itemID});
		
		jdbcTemplate.update(sqlHuespedDTO, new Object[] { reservation.getHuesped().getIdHuesped(),
														reservation.getRoom().getIdRoom(), facturaID});
	}

	private String generateNumFact(Reservacion res) {
		StringBuilder bld = new StringBuilder();
		bld.append(res.getHuesped().getIdHuesped()).append(res.getRoom().getIdRoom())
		.append(new SimpleDateFormat("yyyyMMdd").format(res.getRoom().getCheckIn())).append(new SimpleDateFormat("yyyyMMdd").format(res.getRoom().getCheckOut()));
		return bld.toString();
	}
	
	private int daysBetweenUsingJoda(Date d1, Date d2){
		return Days.daysBetween(
		           new LocalDate(d1.getTime()), 
		           new LocalDate(d2.getTime())).getDays();
	}

	@Override
	public List<Reservacion> findReservationByHuespedId(Long id) {
		String sql = "SELECT h.nombre, h.apellido, r.room, r.checkin, "
				+ "r.checkout,f.facturaID, f.serie, f.numfact, f.total "
				+ "FROM huesped h INNER JOIN huespeddto ht "
				+ "ON h.huespedID = ht.huespedID "
				+ "INNER JOIN room r ON ht.roomID = r.roomID "
				+ "INNER JOIN factura f ON ht.facturaID = f.facturaID "
				+ "WHERE ht.huespedIDD = ?";
		
		return jdbcTemplate.query(sql, new Object[] { id } ,new RowMapper<Reservacion>() {

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
				
				factura.setIdFactura(rs.getLong("facturaID"));
				factura.setSerie(rs.getString("serie"));
				factura.setNumfact(rs.getString("numfact"));
				reservacion.setHuesped(huesped);
				reservacion.setRoom(room);
				reservacion.setFactura(factura);
				return reservacion;
			}
		});
	}
}
