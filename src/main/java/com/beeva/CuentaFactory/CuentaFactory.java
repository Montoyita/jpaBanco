package com.beeva.CuentaFactory;
import com.beeva.CuentaDAOInter.CuentaDAOInter;
import com.beeva.CuentaImpl.CuentaAhorrosImpl;
import com.beeva.CuentaImpl.CuentaChequesImpl;
import com.beeva.VO.Cuenta;

public class CuentaFactory {
	
	public CuentaFactory()
	{
		
	}
	
	public CuentaDAOInter getImplements(int i)
	{
		if(i == 1)
		{
			return new CuentaAhorrosImpl();
		}else if(i == 2)
		{
			 return new CuentaChequesImpl();
		}
			return null;
	}

}
