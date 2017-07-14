package com.beeva.CuentaImpl;
import javax.management.Query;
import javax.persistence.EntityManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.CuentaDAOInter.CuentaDAOInter;
import com.beeva.DAO.ClienteDAO;
import com.beeva.DAO.CuentaDAO;
import com.beeva.DAOImpl.ClienteDAOImpl;
import com.beeva.DAOImpl.CuentaDAOImpl;
import com.beeva.VIEW.ES;
import com.beeva.VO.Cliente;
import com.beeva.VO.Cuenta;

/**
 *
 * @author administradorcito
 */
public class CuentaAhorrosImpl implements CuentaDAOInter{

	public CuentaAhorrosImpl()
    {
    }
	
	public boolean deposito(Cuenta cuenta, double cantidad)
    {
    	boolean resultado = false;
    	if (cuenta != null && cantidad != 0.0){
	    	double nuevoBalance = cuenta.getBalance() + cantidad;
	    	cuenta.setBalance(nuevoBalance);
	    	
	    	ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");
	    	context.getBean(CuentaDAOImpl.class).update(cuenta); 
	    	resultado = true;
		}
		else {
			ES.escribe("Error en la captura de tus datos");
		}	
        return resultado;        
    }
    
    public boolean retiro(Cuenta cuenta, double cantidad)
    {
    	boolean resultado = false;
		if (cuenta.getBalance() > 5000){
			double nuevoBalance = cuenta.getBalance() - cantidad;
	    	cuenta.setBalance(nuevoBalance);
	    	
	    	ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");
	    	context.getBean(CuentaDAOImpl.class).update(cuenta);
	    	resultado = true;
		}
		else {
			ES.escribe("No hay saldo suficiente para retirar esa cantidad");
		}
			return resultado;
    }
    
}
