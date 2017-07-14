package com.beeva.CuentaDAOInter;

import com.beeva.VO.Cuenta;

public interface CuentaDAOInter 
{	
	public boolean deposito(Cuenta cuenta, double cantidad);
	public boolean retiro(Cuenta cuenta, double cantidad);
}
