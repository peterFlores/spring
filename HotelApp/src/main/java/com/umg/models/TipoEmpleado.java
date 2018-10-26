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
@Table(name = "tipoempleado")
public class TipoEmpleado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "tipoEmpleadoID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tipoEmpleadoID;
	
	@Column(name = "nombreTipoEmpleado")
	private String nombreTipoEmpleado;
	
	private String permisos;

	@OneToMany(cascade =  CascadeType.ALL,mappedBy = "tipoEmpleado")
	@JsonIgnore
	private Set<Usuario> usuario;
	
	
	public Long getTipoEmpleadoID() {
		return tipoEmpleadoID;
	}
	public void setTipoEmpleadoID(Long tipoEmpleadoID) {
		this.tipoEmpleadoID = tipoEmpleadoID;
	}
	public String getNombreTipoEmpleado() {
		return nombreTipoEmpleado;
	}
	public void setNombreTipoEmpleado(String nombreTipoEmpleado) {
		this.nombreTipoEmpleado = nombreTipoEmpleado;
	}
	public String getPermisos() {
		return permisos;
	}
	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}
	
}

