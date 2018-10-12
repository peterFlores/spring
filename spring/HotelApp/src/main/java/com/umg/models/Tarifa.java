package com.umg.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	

}
