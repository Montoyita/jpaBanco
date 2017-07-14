package com.beeva.MODEL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.VO.Banco;
import com.beeva.VO.Cliente;
import com.beeva.VO.Cuenta;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;


public class LogMongo {

	private Calendar cal = Calendar.getInstance();
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private String base = "";
	private String documento;
	private ApplicationContext context;
	private MongoClient mongo;
	private DB db;
	
	
	public LogMongo(String base, String documento)
	{
		this.documento = documento;
		this.context = new ClassPathXmlApplicationContext("mongo-context.xml");
		this.mongo = (MongoClient)context.getBean("mongo");
		this.db = mongo.getDB(base);
		
	}
	
	public void agregarBancoLog(Banco banco)
	{
		System.out.println("base: "+db);
		System.out.println("documento: "+documento);
		
		DBCollection table = db.getCollection(documento);
		BasicDBObject document = new BasicDBObject();
		
		document.put("mensaje","Se inserto una cuenta nueva");
		document.put("id",banco.getIdBanco());
		document.put("nombre",banco.getNombre());
		document.put("fecha",dateFormat.format(cal.getTime()));
		
		table.insert(document);
	}
	
	public void agregaCuentaLog(Cuenta cuenta)
	{
		
		DBCollection table = db.getCollection(documento);
		BasicDBObject document = new BasicDBObject();
		document.put("mensaje:","Se inserto una cuenta nueva");
		document.put("id",cuenta.getIdcuenta());
		document.put("balance",cuenta.getBalance());
		document.put("tipocuenta",cuenta.getIdtipoCuenta());
		document.put("clienteid",cuenta.getIdcliente());
		document.put("fecha",dateFormat.format(cal.getTime()));
		
		table.insert(document);
	}
	
	public void agregaClienteLog(Cliente cliente)
	{
		DBCollection table = db.getCollection(documento);
		BasicDBObject document = new BasicDBObject();
		document.put("mensaje:","Se inserto un cliente nuevo");
		document.put("id",cliente.getIdCliente());
		document.put("nombre",cliente.getNombre());
		document.put("apellido",cliente.getApellido());
		document.put("fecha",dateFormat.format(cal.getTime()));
		
		table.insert(document);
	}
}
