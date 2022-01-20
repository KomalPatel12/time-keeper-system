package edu.ssdi.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	 
	 public static Connection createConnection()
	 {
	     Connection con = null;
	     String url = "jdbc:mysql://localhost:3306/test"; //MySQL URL followed by the database name
	     String username = "admin"; //MySQL username
	     String password = "ssdi"; //MySQL password
	     
	     try 
	     {
	         try 
	         {
	            Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
	         } 
	         catch (ClassNotFoundException e)
	         {
	            e.printStackTrace();
	         }       
	         System.out.println("url:" +url+"uname:"+username+"password:"+password);
	         con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
	         System.out.println("Printing connection object "+con);
	     } 
	     catch (Exception e) 
	     {
	        e.printStackTrace();
	     }   
	     System.out.println("DB file Connection:"+con);
	     return con; 
	 }
}
