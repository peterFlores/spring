package com.umg.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tarifa")
public class Tarifa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "tarifaID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTarifa;
	private String tarifa;
	private Double costo;
	
	@OneToMany(cascade =  CascadeType.ALL,mappedBy = "tarifa")
	@JsonIgnore
	private Set<Room> room;
	
	
	public Tarifa() {
		
	}
	
	
	
	public Tarifa(String tarifa, Double costo, Room room) {
		
		this.tarifa = tarifa;
		this.costo = costo;
	}



	public Long getIdTarifa() {
		return idTarifa;
	}
	public void setIdTarifa(Long idTarifa) {
		this.idTarifa = idTarifa;
	}
	public String getTarifa() {
		return tarifa;
	}
	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}



	public Set<Room> getRoom() {
		return room;
	}



	public void setRoom(Set<Room> room) {
		this.room = room;
	}
	
	
	
	

}
