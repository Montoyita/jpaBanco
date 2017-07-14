package com.beeva.CuentaImpl;
import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.CuentaDAOInter.CuentaDAOInter;
import com.beeva.DAOImpl.CuentaDAOImpl;
import com.beeva.VIEW.ES;
import com.beeva.VO.Cliente;
import com.beeva.VO.Cuenta;
/**
 *
 * @author administradorcito
 */
public class CuentaChequesImpl implements CuentaDAOInter
{
    
    public CuentaChequesImpl()
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
    	Calendar cal = Calendar.getInstance();
		int diaActual = cal.get(Calendar.DAY_OF_WEEK);
		
		if (diaActual != 1 && diaActual != 7){
			double nuevoBalance = cuenta.getBalance() - cantidad;
	    	cuenta.setBalance(nuevoBalance);
	    	
	    	ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");
	    	context.getBean(CuentaDAOImpl.class).update(cuenta);
	    	resultado = true;
		}
		else {
			ES.escribe("En dias inhabiles no se permiten retiros");
		}
			return resultado;
    }
}
