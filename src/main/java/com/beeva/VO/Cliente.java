package com.beeva.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcliente;
	private String nombre;
	private String apellido;
	public int getIdCliente() {
		return idcliente;
	}
	public void setIdCliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}


