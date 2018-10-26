package com.umg.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "roomID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRoom;
	
	private String room;
	
	@Column(name = "checkin", nullable = true)
	private Date checkIn;
	

	@Column(name = "checkout", nullable = true)
	private Date checkOut;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "tarifaID")
	private Tarifa tarifa;
	
	public Room() {
		
	}
	
	public Room(String room, Date checkIn, Date checkOut, String status) {
		this.room = room;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.status = status;
	}
	public Long getIdRoom() {
		
		return idRoom;
	}
	public void setIdRoom(Long idRoom) {
		this.idRoom = idRoom;
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
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public Tarifa getTarifa() {
		return tarifa;
	}
	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}
	
	
	
}
