package com.beeva.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bancosclientes")
public class BancosClientes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idbancosclientes;
	private int idcliente;
	private int idbanco;
	
	public int getIdbancosclientes() {
		return idbancosclientes;
	}
	public void setIdbancosclientes(int idbancosclientes) {
		this.idbancosclientes = idbancosclientes;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public int getIdbanco() {
		return idbanco;
	}
	public void setIdbanco(int idbanco) {
		this.idbanco = idbanco;
	}
	
	
	
}
