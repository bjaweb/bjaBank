package com.bja.bapps.bjaBank.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.junit.Test;

public class JDBCConnect {

	
	@Test
	public void connec(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
		         
//		      String url = "jdbc:mysql://localhost:3306/test?user=admin&password=admin";
			String url = "jdbc:mysql://bjanas:3306/test";
		      String user = "root";
		      String passwd = "toto";
		         
//			  String user = "admin";
//		      String passwd = "admin";
			
//			  String user = "ben";
//		      String passwd = "benjanv";
		      
		      Connection conn = DriverManager.getConnection(url, user, passwd);
		         
		      //Création d'un objet Statement
		      Statement state = conn.createStatement();
		      //L'objet ResultSet contient le résultat de la requête SQL
		      ResultSet result = state.executeQuery("SELECT * FROM CONTACT");
		      //On récupère les MetaData
		      ResultSetMetaData resultMeta = result.getMetaData();
		         
		      System.out.println("\n**********************************");
		      //On affiche le nom des colonnes
		      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
		         
		      System.out.println("\n**********************************");
		         
		      while(result.next()){         
		        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		          System.out.print("\t" + result.getObject(i).toString() + "\t |");
		            
		        System.out.println("\n---------------------------------");

		      }

		      result.close();
		      state.close();
		         
		    } catch (Exception e) {
		      e.printStackTrace();
		    }      
		
		
	}
}
