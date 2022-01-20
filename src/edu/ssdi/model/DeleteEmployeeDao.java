/* ******************
 * 
 * 
 Author: Komal Patel
 	This class class defines model(DAO-Data Access Object) for database connection and related operations to Delete Employee functionality.
 * 
 *
 ********************/
package edu.ssdi.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class DeleteEmployeeDao { 
     public String deleteEmployee(int empId) throws Exception
     {    
         PreparedStatement ps = null;
         try
         {
        		String url = "jdbc:mysql://localhost:3306/timekeepersystem";
        		String dbUsername = "admin";
        		String dbPassword = "ssdi";
        		        		
        			Class.forName("com.mysql.jdbc.Driver");
        			Connection con = DriverManager.getConnection(url, dbUsername, dbPassword); 

             String query = "UPDATE employee SET currentEmployee = 0 WHERE empId = " + empId;
             ps = con.prepareStatement(query); 
             
             int i= ps.executeUpdate();
             
             if (i!=0)  
   				return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "Oops.. Something went wrong there..!";          
     }
}