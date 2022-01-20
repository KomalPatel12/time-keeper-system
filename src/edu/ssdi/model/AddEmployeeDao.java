/* ******************
 * 
 * 
 Author: Komal Patel
 	This class defines model(DAO-Data Access Object) for database connection and related operations to Add Employee Details functionality.
 * 
 *
 ********************/
package edu.ssdi.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.ssdi.bean.EmployeeBean;
 
public class AddEmployeeDao { 
	
	  PreparedStatement ps = null;
     		String url = "jdbc:mysql://localhost:3306/timekeepersystem";
     		String dbUsername = "admin";
     		String dbPassword = "ssdi";
     		String roleId = "";

     public String addNewUser(EmployeeBean employeeBean) throws Exception
     {
         String firstName = employeeBean.getFirstName();
         String middleName = employeeBean.getMiddleName();
         String lastName = employeeBean.getLastName();
         String birthDate = employeeBean.getBirthDate();
         String gender = employeeBean.getGender();
         String phoneNumber = employeeBean.getPhoneNumber();
         String email = employeeBean.getEmail();
         String ssn = employeeBean.getSsn();
         String highestEducation = employeeBean.getHighestEducation();

         String effectiveDate = employeeBean.getEffectiveDate();
         String joiningDate = employeeBean.getJoiningDate();
         String joiningPosition = employeeBean.getJoiningPosition();
         String employementType = employeeBean.getEmploymentType();
         String managerId = employeeBean.getManagerId();
         String departmentName = employeeBean.getDepartmentName();
         String project = employeeBean.getProject();
         String designation = employeeBean.getDesignation();
         
         //Assumption: There can be only on Admin with roleId=1
         if(designation.equalsIgnoreCase("Manager")){
        	 roleId="2"; //roleId for 'Manager'
         } else { 
        	 roleId = "3"; //roleId for 'Employee'
         }
         
       try {
    	   Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, dbUsername, dbPassword); 
			
             String query = "INSERT INTO employee(empId,firstName,middleName,lastName,birthDate,gender,phoneNumber,email,ssn,highestEducation,designation,effectiveDate,joiningDate,joiningPosition,employmentType,managerId,departmentName,project,roleId) values (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; //Insert user details into 'EMPLOYEE' table
             ps = con.prepareStatement(query); 

             ps.setString(1, firstName);
             ps.setString(2, middleName);
             ps.setString(3, lastName);
             ps.setString(4, birthDate);
             ps.setString(5, gender);
             ps.setString(6, phoneNumber);
             ps.setString(7, email);
             ps.setString(8, ssn);
             ps.setString(9, highestEducation);
             ps.setString(10, designation);
             ps.setString(11, effectiveDate);
             ps.setString(12, joiningDate);
             ps.setString(13, joiningPosition);
             ps.setString(14, employementType);
             ps.setString(15, managerId);
             ps.setString(16, departmentName);
             ps.setString(17, project);
             ps.setString(18, roleId);
             
             int i= ps.executeUpdate();


             if (i!=0)  //Confirm data insertion
             return "SUCCESS"; 
        		}
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "Oops.. Something went wrong there..!";          
     }
     
     public int getEmpId() throws Exception {
    	 int maxValue = 0;
    	 try {
    		 Class.forName("com.mysql.cj.jdbc.Driver");
  			Connection con = DriverManager.getConnection(url, dbUsername, dbPassword); 

    	 String getMax = "SELECT MAX(empId) FROM timekeepersystem.employee";
	        
    	 ps = con.prepareStatement(getMax);
    	 
    	 ps.executeQuery();
    	 ResultSet rs = ps.getResultSet();
    	 if(rs.next()) {
    		  maxValue = rs.getInt(1);
    	 }
    	 ps.close();
    	 con.close();

     }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
        return maxValue;
     }
  
     public String getUserFirstName() throws Exception {
    	String firstName = "";
    	 try {
    		 Class.forName("com.mysql.cj.jdbc.Driver");
  			Connection con = DriverManager.getConnection(url, dbUsername, dbPassword); 

    	 String query = "SELECT firstName FROM timekeepersystem.employee WHERE empId="+getEmpId();
	        
    	 ps = con.prepareStatement(query);
    	 
    	 ps.executeQuery();
    	 ResultSet rs = ps.getResultSet();
    	 if(rs.next()) {
    		 firstName = rs.getString(1);
    	 }
    	 ps.close();
    	 con.close();

     }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
        return firstName;
     }
     
     public String createCredentials() throws Exception {
    	 int empId = getEmpId();
    	 String firstName = getUserFirstName(); 
    	 String userName = firstName+empId;
    	 try {
      	   Class.forName("com.mysql.cj.jdbc.Driver");
  			Connection con = DriverManager.getConnection(url, dbUsername, dbPassword); 
  			
               String query = "INSERT INTO useraccount(empId,userName,password) values (?,?,?)"; 
               ps = con.prepareStatement(query); 
               
               ps.setInt(1, empId);
               ps.setString(2, userName);
               ps.setString(3, firstName);

               ps.executeUpdate();
               ps.close();
               con.close();

           }
               catch(SQLException e)
               {
                  e.printStackTrace();
               }       
              return "Error";
     }
}