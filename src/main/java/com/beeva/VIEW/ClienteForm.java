package com.beeva.VIEW;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.DAO.BancoDAO;
import com.beeva.DAOImpl.BancoDAOImpl;
import com.beeva.VO.Banco;
import com.beeva.controller.Eventos;

import java.util.*;
import java.io.*;
import java.sql.*;

public class ClienteForm extends JFrame implements ActionListener{
	
	//
	int bancoVal = 0;
	String nomVal = "";
	String appVal = "";   	             
    double balanceVal = 0.0;
    int tipocuenVal = 0;
	
	//MENU SUPERIOR
	private JMenuBar menubar;
    private JMenu opcion1;
    private JMenuItem opNuevocliente; 
    private JMenuItem opNuevacuenta;
    private JMenuItem opAyuda;
    private JMenuItem opSalir;
    
   //LABELS INICIALIZACION
   private JLabel etiquetaNombreBanco;
   private JLabel etiquetaNombreCliente;
   private JLabel etiquetaApellidoCliente;
   private JLabel etiquetaTipoCuenta;
   private JLabel etiquetaBalance;
   
   //TEXTFIELDS INICIALIZACION
   private JComboBox banco;
   private JTextField nombreCliente;
   private JTextField apellidoCliente;
   private JTextField balance;
   private JComboBox tipoCuenta;

   //BOTONES INICIALIZACION
   private JButton agregaCliente;
   private JButton depositar;
   private JButton retirar;
   private JButton salir;
   private JButton llenarCatalogos;
    
   
   public ClienteForm()
   {
      super("Beeva");
      Container contenedor = getContentPane();
      contenedor.setLayout(null);
      
      setSize(650,440);
      setVisible(true);
      
      //INSTANCIANDO MENU SUPERIOR
      menubar = new JMenuBar();
      setJMenuBar(menubar);
      opcion1 = new JMenu("Opciones");
      menubar.add(opcion1);
      
      opNuevocliente = new JMenuItem("Cliente nuevo");
      opNuevocliente.addActionListener(this);
      opcion1.add(opNuevocliente);
      
      opNuevacuenta = new JMenuItem("Cuenta nueva");
      opNuevacuenta.addActionListener(this);
      opcion1.add(opNuevacuenta);
      
      opAyuda = new JMenuItem("Ayuda");
      opAyuda.addActionListener(this);
      opcion1.add(opAyuda); 
      
      opSalir = new JMenuItem("Salir");
      opSalir.addActionListener(this);
      opcion1.add(opSalir);     
      
      //INSTANCIANDO LABELS
      etiquetaNombreBanco = new JLabel("Banco: ");
      etiquetaNombreCliente = new JLabel("Nombre del cliente: ");
      etiquetaApellidoCliente = new JLabel("Apellido del cliente: ");
      etiquetaTipoCuenta = new JLabel("Tipo de cuenta: ");
      etiquetaBalance = new JLabel("Saldo de apertura: ");
      
      //INSTANCIANDO CAMPOS
      banco = new JComboBox();
      nombreCliente = new JTextField(20);
      apellidoCliente = new JTextField(20);
      tipoCuenta = new JComboBox();
      balance = new JTextField(20);
      
      //_____________________________________ETIQUETAS Y CAMPOS____________________________________________________
      
      contenedor.add(etiquetaNombreBanco);
      etiquetaNombreBanco.setBounds(10,50,160,45);
      contenedor.add(banco);
      banco.setBounds(130,50,200,45);
      banco.addItem("Bancomer");
      banco.addItem("Santander");
      banco.addItem("HSBC");
      
      contenedor.add(etiquetaNombreCliente);
      etiquetaNombreCliente.setBounds(10,110,160,45);
      contenedor.add(nombreCliente);
      nombreCliente.setBounds(130,110,200,45);
      
      contenedor.add(etiquetaApellidoCliente);
      etiquetaApellidoCliente.setBounds(10,170,160,45);
      contenedor.add(apellidoCliente);
      apellidoCliente.setBounds(130,170,200,45);
      
      contenedor.add(etiquetaTipoCuenta);
      etiquetaTipoCuenta.setBounds(10,230,160,45);
      contenedor.add(tipoCuenta);
      tipoCuenta.setBounds(130,230,200,45);
      tipoCuenta.addItem("Ahorros");
      tipoCuenta.addItem("Cheques");
   
      contenedor.add(etiquetaBalance);
      etiquetaBalance.setBounds(10,290,160,45);
      contenedor.add(balance);
      balance.setBounds(130,290,200,45);
      
      
      // INSTANCIANDO BOTONES
      agregaCliente = new JButton("Agregar");
      contenedor.add(agregaCliente);
      agregaCliente.setBounds(340,50,200,50);
      
      depositar = new JButton("Depositar a cuenta");
      contenedor.add(depositar);
      depositar.setBounds(340,110,200,50);
      
      retirar = new JButton("Retirar de cuenta");
      contenedor.add(retirar);
      retirar.setBounds(340,170,200,50);
      
      salir = new JButton("Salir");
      contenedor.add(salir);
      salir.setBounds(340,230,200,50);
      
      llenarCatalogos = new JButton("Llenar catalogos");
      contenedor.add(llenarCatalogos);
      llenarCatalogos.setBounds(340,290,200,50);
       
      
      //LISTENERS
      agregaCliente.addActionListener(
    	         new ActionListener() {
    	            public void actionPerformed(ActionEvent ev)
    	            {  
    	            	bancoVal = banco.getSelectedIndex()+1;
    	                nomVal = nombreCliente.getText();
    	                appVal = apellidoCliente.getText();    	             
    	                balanceVal = (double)Double.parseDouble(balance.getText());
    	                tipocuenVal= tipoCuenta.getSelectedIndex()+1;
    	            	Eventos evento = new Eventos();
    	                evento.insertaClienteNuevo(bancoVal, nomVal, appVal, balanceVal, tipocuenVal);
    	                limpiarFormulario();
    	            }
    	         }
    	      );
      
      depositar.addActionListener(
 	         new ActionListener() {
 	            public void actionPerformed(ActionEvent ev)
 	            {  
 	            	int idcuenta = ES.leeInteger("Ingrese numero de cuenta (idCuenta): ");
 	            	double cantidad = ES.leeDouble("Ingrese cantidad: ");
 	            	int tipocuenta = ES.leeInteger("Ingresa numero, segun el tipo de cuenta"
 	            									+ "\nAhorros --> 1"
 	            									+ "\ncheques --> 2)");
 	            	Eventos evento = new Eventos();
 	            	evento.depositar(idcuenta, cantidad, tipocuenta);
 	            }
 	         }
 	      );
      
      retirar.addActionListener(
  	         new ActionListener() {
  	            public void actionPerformed(ActionEvent ev)
  	            {  
  	            	int idcuenta = ES.leeInteger("Ingrese numero de cuenta (idCuenta): ");
 	            	double cantidad = ES.leeDouble("Ingrese cantidad: ");
 	            	int tipocuenta = ES.leeInteger("Ingresa numero, segun el tipo de cuenta"
 	            									+ "\nAhorros --> 1"
 	            									+ "\ncheques --> 2)");
 	            	Eventos evento = new Eventos();
 	            	evento.depositar(idcuenta, cantidad, tipocuenta);
  	            }
  	         }
  	      );
      
      salir.addActionListener(
    	         new ActionListener() {
    	            public void actionPerformed(ActionEvent ev)
    	            {
    	               System.exit(0);
    	            }
    	         }
    	      );
      llenarCatalogos.addActionListener(
 	         new ActionListener() {
 	            public void actionPerformed(ActionEvent ev)
 	            {
 	            	Eventos evento = new Eventos();
 	            	evento.llenarCatalogos();
 	            	quitar();
 	        	}
 	         }
 	      ); 
      
   	 }
   
    public void quitar(){
    	llenarCatalogos.setEnabled(false);
    }

   	//ACCIONES DEL JMENU
	public void actionPerformed(ActionEvent e) {
		Container f = this.getContentPane();
        if (e.getSource() == opNuevocliente) {
        	ClienteForm clienteForm = new ClienteForm();
        	this.setVisible(false);
        	clienteForm.setVisible(true);
        }
        if (e.getSource() == opNuevacuenta) {
        	CuentaForm cuentaForm = new CuentaForm();
        	this.setVisible(false);
        	cuentaForm.setVisible(true);
        } 
        if (e.getSource() == opAyuda) {
        	ES.escribe("Instrucciones de uso: \n"
        			+ "----MENU OPCIONES----"
        			+"\n Cliente nuevo: Permite ir a formulario para registrar un nuevo cliente con todo y cuenta"
        			+"\n Cuenta nueva: Permite ir a formulario para agregar una cuenta a un cliente previamente registrado"
        			+"\n Ayuda: Permite leer el instructivo"
        			+"\n Llenar catalogos: Boton usado por unica vez, antes de comenzar a usar la app"
        			+"\n Salir: Cerrar el programa"
        			+"\n\n"
        			+ "----BOTONES----"
        			+"\n Agregar: Registra los datos actuales del formulario"
        			+"\n Depositar: Genera una ventana para indicar cantidad y num de cuenta para depositar"
        			+"\n Retirar: Genera una ventana para indicar cantidad y num de cuenta"
        			+"\n Salir: Cerrar el programa"
        			);
        } 
        if (e.getSource() == opSalir) {
        	System.exit(0);
        } 
		
	}
	
	public void limpiarFormulario(){
		banco.setSelectedItem("Bancomer");
		nombreCliente.setText("");
		apellidoCliente.setText("");
		balance.setText("");
		tipoCuenta.setSelectedItem("Ahorros");
	}
}