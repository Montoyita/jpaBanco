package com.beeva.VIEW;

public class ES {
	   public static void escribe (String cad)
	   {	   
		   javax.swing.JOptionPane.showMessageDialog(null, cad);
	   }

	   static int leeInteger(String cad)
	   {
	      int n;
	      n = Integer.parseInt(javax.swing.JOptionPane.showInputDialog(cad));
	      return n;
	   }
	   
	   static String leeString (String cad)
	   {
	      String n;
	      n = javax.swing.JOptionPane.showInputDialog(cad);
	      return n;
	   }
	   
	   static Double leeDouble (String cad)
	   {
	      double n;
	      n = Double.parseDouble(javax.swing.JOptionPane.showInputDialog(cad));
	      return n;
	   }
	}