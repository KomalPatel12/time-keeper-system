/* ******************
 * 
 * 
 Author: Komal Patel
 	This class defines model(DAO-Data Access Object) for database connection and related operations to Reset Password functionality.
 * 
 *
 ********************/

package edu.ssdi.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.ssdi.bean.EmployeeBean;

public class ResetPasswordDao {
	EmployeeBean employeeBean = new EmployeeBean();

	public String resetPassword(EmployeeBean employeeBean) throws Exception {
		
		int empId = employeeBean.getEmployeeId();
		
		String newPassword = employeeBean.getNewPassword();
		PreparedStatement ps = null;
        try
        {
       		String url = "jdbc:mysql://localhost:3306/timekeepersystem";
       		String dbUsername = "admin";
       		String dbPassword = "ssdi";
       		
       			Class.forName("com.mysql.jdbc.Driver");
       			Connection con = DriverManager.getConnection(url, dbUsername, dbPassword); 

            String query = "UPDATE useraccount SET password=? WHERE empId="+ empId;
            ps = con.prepareStatement(query); 

            ps.setString(1, newPassword);
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
