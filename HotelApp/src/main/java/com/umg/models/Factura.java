package com.umg.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Factura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idFactura;
	private String serie;
	private String numfact;
	private Float total;
	private List<ItemFactura> items = new ArrayList<ItemFactura>();
	public Long getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getNumfact() {
		return numfact;
	}
	public void setNumfact(String numfact) {
		this.numfact = numfact;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public List<ItemFactura> getItems() {
		return items;
	}
	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
	
	

}
