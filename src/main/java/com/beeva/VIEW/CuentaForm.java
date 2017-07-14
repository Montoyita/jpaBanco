package com.beeva.VIEW;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.beeva.controller.Eventos;

import java.util.*;
import java.io.*;
import java.sql.*;

public class CuentaForm extends JFrame implements ActionListener{
	
	//
	int bancoVal = 0;
	int clienteVal = 0;   	             
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
    private JLabel etiquetaCliente;
    private JLabel etiquetaTipoCuenta;
    private JLabel etiquetaBalance;
   
   //TEXTFIELDS INICIALIZACION
   private JComboBox banco;
   private JComboBox cliente;
   private JComboBox tipoCuenta;
   private JTextField balance;

   //BOTONES INICIALIZACION
   private JButton agregaCuenta;
   private JButton depositar;
   private JButton retirar;
   private JButton salir;
   
   public CuentaForm()
   {
      super("Beeva");
      Container contenedor = getContentPane();
      contenedor.setLayout(null);
      
      setSize(650,440);
      setVisible(false);
      
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
      etiquetaCliente = new JLabel("Cliente: ");
      etiquetaTipoCuenta = new JLabel("Tipo de cuenta: ");
      etiquetaBalance = new JLabel("Tipo de cuenta: ");
      
      //INSTANCIANDO CAMPOS
      banco = new JComboBox();
      cliente = new JComboBox();
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
      
      contenedor.add(etiquetaCliente);
      etiquetaCliente.setBounds(10,110,160,45);
      contenedor.add(cliente);
      cliente.setBounds(130,110,200,45);
      cliente.addItem("Cliente 1");
      cliente.addItem("Cliente 2");
      cliente.addItem("Cliente 3");
      
      contenedor.add(etiquetaTipoCuenta);
      etiquetaTipoCuenta.setBounds(10,170,160,45);
      contenedor.add(tipoCuenta);
      tipoCuenta.setBounds(130,170,200,45);
      tipoCuenta.addItem("Ahorros");
      tipoCuenta.addItem("Cheques");
      
      contenedor.add(etiquetaBalance);
      etiquetaBalance.setBounds(10,230,160,45);
      contenedor.add(balance);
      balance.setBounds(130,230,200,45);
   
      
      // INSTANCIANDO BOTONES
      agregaCuenta = new JButton("Agregar");
      contenedor.add(agregaCuenta);
      agregaCuenta.setBounds(340,50,200,50);
      
      depositar = new JButton("Depositar a cuenta");
      contenedor.add(depositar);
      depositar.setBounds(340,110,200,50);
      
      retirar = new JButton("Retirar de cuenta");
      contenedor.add(retirar);
      retirar.setBounds(340,170,200,50);
      
      salir = new JButton("Salir");
      contenedor.add(salir);
      salir.setBounds(340,230,200,50);
      
      //LISTENERS
      agregaCuenta.addActionListener(
    	         new ActionListener() {
    	            public void actionPerformed(ActionEvent ev)
    	            {    	            	   
    	            	bancoVal = banco.getSelectedIndex()+1;
    	            	clienteVal = cliente.getSelectedIndex()+1;
    	            	tipocuenVal= tipoCuenta.getSelectedIndex()+1;
    	                balanceVal = (double)Double.parseDouble(balance.getText());
    	               
    	            	Eventos evento = new Eventos();
    	                evento.insertaCuentaNueva(bancoVal, clienteVal, tipocuenVal, balanceVal);
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
   }
   
   	//ACCIONES DEL JMENU
	public void actionPerformed(ActionEvent e) {
		Container f = this.getContentPane();
        if (e.getSource() == opNuevocliente) {
            ClienteForm clienteForm = new ClienteForm();
        	this.setVisible(false);
        	clienteForm.setVisible(true);
        	
        	clienteForm.quitar();
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
		cliente.setSelectedItem("Cliente1");
		tipoCuenta.setSelectedItem("Ahorros");
		balance.setText("");
		
	}
}