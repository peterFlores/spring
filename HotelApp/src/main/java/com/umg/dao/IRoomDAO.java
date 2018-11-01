package com.umg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.umg.models.Room;

public interface IRoomDAO extends CrudRepository<Room, Long> {
	
	@Query("SELECT r from Room r WHERE r.status = 'D'")
	public List<Room> findAllByStatus();
}
