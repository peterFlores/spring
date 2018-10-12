package com.umg.models;

import java.io.Serializable;
import java.util.Date;

public class Room implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idRoom;
	private Integer idTarifa;
	private Date checkIn;
	private Date checkOut;
	private String status;
	public Long getIdRoom() {
		
		return idRoom;
	}
	public void setIdRoom(Long idRoom) {
		this.idRoom = idRoom;
	}
	public Integer getIdTarifa() {
		return idTarifa;
	}
	public void setIdTarifa(Integer idTarifa) {
		this.idTarifa = idTarifa;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
