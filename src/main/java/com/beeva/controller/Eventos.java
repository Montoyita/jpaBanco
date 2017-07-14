package com.beeva.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.CuentaDAOInter.CuentaDAOInter;
import com.beeva.CuentaFactory.CuentaFactory;
import com.beeva.DAO.BancoDAO;
import com.beeva.DAO.BancosClientesDAO;
import com.beeva.DAO.ClienteDAO;
import com.beeva.DAO.CuentaDAO;
import com.beeva.DAO.TipoCuentaDAO;
import com.beeva.DAOImpl.BancoDAOImpl;
import com.beeva.DAOImpl.BancosClientesDAOImpl;
import com.beeva.DAOImpl.ClienteDAOImpl;
import com.beeva.DAOImpl.CuentaDAOImpl;
import com.beeva.DAOImpl.TipoCuentaDAOImpl;
import com.beeva.VIEW.ES;
import com.beeva.VO.Banco;
import com.beeva.VO.BancosClientes;
import com.beeva.VO.Cliente;
import com.beeva.VO.Cuenta;
import com.beeva.VO.TipoCuenta;

public class Eventos {
	
	public void insertaClienteNuevo(int bancoVal, String nomVal, String appVal, double balanceVal, int tipocuenVal){
		
		/*System.out.println("\n"+bancoVal+
				"\n"+nomVal+
				"\n"+appVal+
				"\n"+balanceVal+
				"\n"+tipocuenVal
				);
		*/
		ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");
		
		ClienteDAO clientedao = (ClienteDAO) context.getBean(ClienteDAOImpl.class);
		CuentaDAO cuentadao = (CuentaDAO) context.getBean(CuentaDAOImpl.class);
		BancosClientesDAO bancliendao = (BancosClientesDAO) context.getBean(BancosClientesDAOImpl.class);
    	
		Cliente cliente = new Cliente();
    	cliente.setNombre(nomVal);
    	cliente.setApellido(appVal);
    	clientedao.save(cliente);	
    	
    	Cuenta cuenta = new Cuenta();
    	cuenta.setBalance(balanceVal);
    	cuenta.setIdtipoCuenta(tipocuenVal);
    	cuenta.setIdcliente(cliente.getIdCliente());
    	cuentadao.save(cuenta);
    	
    	BancosClientes banclientes = new BancosClientes();
    	banclientes.setIdcliente(cliente.getIdCliente());
    	banclientes.setIdbanco(bancoVal);
    	bancliendao.save(banclientes);
    	
    	ES.escribe("Bienvenido a Beeva "+nomVal+" registro de datos exitoso"); 
    	
	}
	
	public void insertaCuentaNueva(int bancoVal, int clienteVal, int tipocuenVal, double balanceVal){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");
		
		CuentaDAO cuentadao = (CuentaDAO) context.getBean(CuentaDAOImpl.class);
		BancosClientesDAO bancliendao = (BancosClientesDAO) context.getBean(BancosClientesDAOImpl.class);
		
		Cuenta cuenta = new Cuenta();
    	cuenta.setBalance(balanceVal);
    	cuenta.setIdtipoCuenta(tipocuenVal);
    	cuenta.setIdcliente(clienteVal);
    	cuentadao.save(cuenta);
    	
    	BancosClientes banclientes = new BancosClientes();
    	banclientes.setIdcliente(clienteVal);
    	banclientes.setIdbanco(bancoVal);
    	bancliendao.save(banclientes);
    	
    	ES.escribe("Ahora tienes una nueva cuenta, registro de datos exitoso"); 	
	}
	
	
	public void depositar(int idcuenta, double cantidad, int tipocuenta){

		ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");
		
		CuentaDAO cuentadao = (CuentaDAO) context.getBean(CuentaDAOImpl.class);
    	Cuenta c = cuentadao.getCuenta(idcuenta);
    	CuentaFactory cfd = new CuentaFactory();
    	CuentaDAOInter cdao = cfd.getImplements(tipocuenta);
    	cdao.deposito(c, cantidad);
	}
	
	public void retirar(int idcuenta, double cantidad, int tipocuenta){
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");
    	
    	CuentaDAO cuentadao = (CuentaDAO) context.getBean(CuentaDAOImpl.class);
    	Cuenta c = cuentadao.getCuenta(idcuenta);
    	CuentaFactory cfd = new CuentaFactory();
    	CuentaDAOInter cdao = cfd.getImplements(tipocuenta);
    	cdao.retiro(c,cantidad);
	}
	
	public void llenarCatalogos(){
		ApplicationContext context = new ClassPathXmlApplicationContext("core-context.xml");
     	
		BancoDAO userdao = (BancoDAO)context.getBean(BancoDAOImpl.class);
        Banco ban = new Banco();
        Banco ban2 = new Banco();
        Banco ban3 = new Banco();
        
        
        ban.setNombre("Bancomer");
        ban2.setNombre("Santander");
        ban3.setNombre("HSBC");
        
        userdao.save(ban);
        userdao.save(ban2);
        userdao.save(ban3);
        
        TipoCuentaDAO tcdao = (TipoCuentaDAO)context.getBean(TipoCuentaDAOImpl.class);
        TipoCuenta tc = new TipoCuenta();
        TipoCuenta tc2 = new TipoCuenta();
        
        tc.setNombre("Ahorros");
        tc2.setNombre("Cheques");
        
        tcdao.save(tc);
        tcdao.save(tc2);
        
	}
	
	
	
	
	
	
	
	
}
