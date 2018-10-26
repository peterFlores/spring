package com.umg.dao;

import org.springframework.data.repository.CrudRepository;

import com.umg.models.Room;

public interface IRoomDAO extends CrudRepository<Room, Long> {

}
