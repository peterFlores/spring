package com.umg.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoempleado")
public class TipoEmpleado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "tipoempleadoID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tipoempleadoID;
	private String nombretipoempleado;
	private String permisos;
	
	public Long gettipoempleadoID() {
		return tipoempleadoID;
	}
	public void settipoempleadoID(Long tipoempleadoID) {
		this.tipoempleadoID = tipoempleadoID;
	}
	public String getnombretipoempleado() {
		return nombretipoempleado;
	}
	public void setnombretipoempleado(String nombretipoempleado) {
		this.nombretipoempleado = nombretipoempleado;
	}
	public String getPermisos() {
		return permisos;
	}
	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}
	
	
}

