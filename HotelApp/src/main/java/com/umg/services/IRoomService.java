package com.umg.services;

import java.util.List;

import com.umg.models.Reservacion;
import com.umg.models.Room;

public interface IRoomService {
	
	public List<Room> findAll();
	
	public Room save(Room room);
	public Room findById(Long id);
	public void deleteById(Long id);
	
	public List<Reservacion> findAllReservations();
	
	public void update(Room room);
	
}
