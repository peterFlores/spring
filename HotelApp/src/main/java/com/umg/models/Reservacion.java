package com.umg.models;

import java.io.Serializable;

public class Reservacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idHuesped;
	private Long idRoom;
	private Long idFactura;
	private Huesped huesped;
	private Room room;
	private Factura factura;
	public Long getIdHuesped() {
		return idHuesped;
	}
	public void setIdHuesped(Long idHuesped) {
		this.idHuesped = idHuesped;
	}
	public Long getIdRoom() {
		return idRoom;
	}
	public void setIdRoom(Long idRoom) {
		this.idRoom = idRoom;
	}
	public Long getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}
	public Huesped getHuesped() {
		return huesped;
	}
	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	

}
