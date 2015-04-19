package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

	   Connection con;  
	   PreparedStatement stmt;  
	   ResultSet rs;  
	     
	   private final String URL = "jdbc:mysql://localhost:3306/gestaoCarnaval";  
	   private final String USER = "root";  
	   private final String PASS = "c4n4lF0t0gr4f0";  
	     
	   protected void open()throws Exception{  
	      Class.forName("com.mysql.jdbc.Driver");  
	      con = DriverManager.getConnection(URL, USER, PASS);  
	   }  
	     
	   protected void close()throws Exception{  
	      con.close();  
	   }  
	     
}
