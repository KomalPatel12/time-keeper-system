package edu.ssdi.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.ssdi.bean.EmployeeBean;

public class CreateCredentialDao {

public String createCredential(int empId) throws Exception {
		
		EmployeeBean employeeBean = new EmployeeBean();

		String username = employeeBean.getUsername();
		String password = employeeBean.getPassword();

		PreparedStatement ps = null;
        try
        {

       		String url = "jdbc:mysql://localhost:3306/timekeepersystem";
       		String dbUsername = "admin";
       		String dbPassword = "ssdi";
       		
       	
       			Class.forName("com.mysql.jdbc.Driver");
       			Connection con = DriverManager.getConnection(url, dbUsername, dbPassword); 

//       			String getEmpId = ""
       			
            String query = "UPDATE employee SET username=?, password=? WHERE empId="+ empId;
            ps = con.prepareStatement(query); 

            ps.setString(1, username);
            ps.setString(2, password);
            
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
