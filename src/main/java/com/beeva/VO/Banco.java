package com.beeva.VO;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="banco")
public class Banco
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idbanco;
	private String nombre;
	
	
	public int getIdBanco() {
		return idbanco;
	}
	public void setIdBanco(int idbanco) {
		this.idbanco = idbanco;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}