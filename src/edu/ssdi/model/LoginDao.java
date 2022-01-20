package edu.ssdi.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ssdi.bean.EmpTimekeeper;
import edu.ssdi.bean.EmployeeBean;
import edu.ssdi.bean.LoginBean;
import edu.ssdi.util.Database;



public class LoginDao {
	
	private Connection connection;
	  
    public LoginDao() {
        connection = Database.getConnection();
}

    public int validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;
        int empId =0;

        Class.forName("com.mysql.jdbc.Driver");

        //connecting to mysql database
        try (Connection connection = DriverManager
         //   .getConnection ("jdbc:mysql://localhost:3306/timekeepersystem", "admin","ssdi"); 
               .getConnection ("jdbc:mysql://localhost:3306/timekeepersystem", "root","Welcome123");
        		

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select empId from useraccount where username = ? and password = ? ")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            if ((rs.next()))
            {
            
              empId = rs.getInt("empId");
              System.out.println(empId);
            }
            
            else 
            {
            	System.out.println("login fail");
            }
        }
        
            catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return empId;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
    
    public EmployeeBean getUserEmp(int empId) {
    	 EmployeeBean emp = new EmployeeBean();
        
        try {
           
            PreparedStatement preparedStatement = connection.prepareStatement("Select empId, firstName , lastName, roleId from Employee\r\n"
            		+ "where empID = ?");
            preparedStatement.setInt(1, empId);
            //System.out.println(managerId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
               
                emp.setEmployeeId(rs.getInt("empId"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setRoleId(rs.getString("roleId"));
                System.out.println("role is "+ emp.getRoleId());
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
       return emp;
    }
 
}