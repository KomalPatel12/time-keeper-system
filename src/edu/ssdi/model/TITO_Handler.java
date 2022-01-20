package edu.ssdi.model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.text.SimpleDateFormat;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;

public class TITO_Handler {
	
	Connection conn;
	Statement query;
	
	public TITO_Handler()
	{
		// pulled straight from mysql docs
		try
		{
			//register driver
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch(Exception ex) {
				System.out.println("Error: unable to load driver class!");
				//System.exit(1);
			}
			
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=admin");
		}catch (SQLException ex)
		{
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		try{
			query = conn.createStatement();}
			catch(Exception e) {System.out.println("error1");}
	    try{
			query.executeUpdate("CREATE DATABASE timekeeper");}
		catch(Exception e) {System.out.println("error2");};
		try{
		    query.executeUpdate("USE timekeeper");}
		catch(Exception e) {System.out.println("error3");};
		try{
		    query.executeUpdate("CREATE TABLE tito_requests (requestID INT, employeeID INT, oldTime DATETIME, newTime DATETIME, reason TEXT);");}
		catch(Exception e) {System.out.println("error4");};
		    System.out.println("Table created");
		
	}
	
	public int makeRequest(Date oldTime, Date newTime, String reason)
	{
		
		int requestID = (int)(Math.random() * 1048576);
		int employeeID = 0; //TODO
		String oldTimeFormatted;
		String newTimeFormatted;
		
		//formatting the strings for the SQL command
		SimpleDateFormat sqlDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		oldTimeFormatted = sqlDateFormat.format(oldTime);
		newTimeFormatted = sqlDateFormat.format(newTime);
		
		try
		{
			Statement query = conn.createStatement();
			query.executeUpdate("USE timekeeper");
			String addString = "INSERT INTO tito_requests(requestID, employeeID, oldTime, newTime, reason) ";
			addString += "VALUES (" + requestID + "," + employeeID + ",'" + oldTimeFormatted + "','" + newTimeFormatted + "','" + reason + "')";
			
			query.executeUpdate(addString);
		}catch (SQLException ex)
		{
			System.out.println("SQLException: " + ex.getMessage());
		}
		return 1;
	}
	public String requestsToTable()
	{
		try
		{
			//register driver
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch(Exception ex) {
				System.out.println("Error: unable to load driver class!");
				System.exit(1);
			}
			
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=admin");

		    // creating the table
		    //don't worry about double creating tables, if will just throw an error and continue
		    query = conn.createStatement();
		    query.executeUpdate("USE timekeeper");
		    ResultSet rs = query.executeQuery("SELECT * FROM tito_requests");
		    
		    String returnString = "";
		    
		    returnString += "<table style=\"width:100%\">";
		    
		    // creating the columns
		    returnString += "<tr><th>Request ID</th><th>Employee ID</th><th>Bad Time</th><th>Replacement Time</th><th>Reason</th></tr>";
		    
		    while(rs.next())
		    {
		    	returnString += "<tr><td style=\"text-align:center\">" + rs.getString(1) + "</td>";
		    	returnString += "<td style=\"text-align:center\">" + rs.getString(2) + "</td>";
		    	returnString += "<td style=\"text-align:center\">" + rs.getString(3) + "</td>";
		    	returnString += "<td style=\"text-align:center\">" + rs.getString(4) + "</td>";
		    	returnString += "<td style=\"text-align:center\">" + rs.getString(5) + "</td></tr>";
		    }
		    returnString += "</table>";
		    		
		    return returnString;
		}catch (SQLException ex)
		{
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    return "Failure";
		}

	}
	
	public void resolveRequest(int requestID, boolean status) throws SQLException
	{
		// confirm that the requestID is valid
		try
		{
			query = conn.createStatement();
		}catch (SQLException ex)
		{
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    return;
		}
		
		ResultSet rs;
		
		try {
			query.executeUpdate("USE timekeeper");
			rs = query.executeQuery("SELECT * FROM tito_requests WHERE requestID = " + requestID);
		}catch(SQLException ex)
		{
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    return;
		}
		
		//confirming that the ID is in the table
		if(!rs.next())
		{
			return;
		}
		

		
	}
}
