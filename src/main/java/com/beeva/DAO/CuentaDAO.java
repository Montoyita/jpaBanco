package com.beeva.DAO;

import com.beeva.VO.Banco;
import com.beeva.VO.Cuenta;

abstract public class CuentaDAO {
	abstract public void save(Cuenta cuenta);
	abstract public void update(Cuenta cuenta);
	abstract public Cuenta getCuenta(int id);
	
}