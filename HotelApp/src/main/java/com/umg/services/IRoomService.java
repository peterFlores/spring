package com.umg.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.umg.models.Reservacion;
import com.umg.models.Room;

public interface IRoomService {
	
	public List<Room> findAll();
	
	public Room save(Room room);
	public Room findById(Long id);
	public void deleteById(Long id);
	
	public List<Room> findAllByStatus();
	
	public List<Reservacion> findAllReservations();
	
	public void update(Room room);
	
	public void insertReservation(Reservacion reservation);
	
	public List<Reservacion> findReservationByHuespedId(Long id);
}
