package com.beeva.jpa.jpaBanco;

import javax.swing.JFrame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.VIEW.ClienteForm;


public class App 
{
    public static void main( String[] args )
    {    	
    	ClienteForm ap = new ClienteForm();
        ap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	System.out.println("HOLA DESDE GIT W10");
	    	
    }
}
