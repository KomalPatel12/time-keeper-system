/* ******************
 * 
 * 
 Author: Komal Patel
 	This class class defines model(DAO-Data Access Object) for database connection and related operations for Editing information of Employee functionality.
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

public class EditEmployeeDao {
	
	public static EmployeeBean getEmployeeDetails(int empId) throws Exception
    {
		EmployeeBean employeeBean = new EmployeeBean();
        try
        {
    		String url = "jdbc:mysql://localhost:3306/timekeepersystem";
    		String dbUsername = "admin";
    		String dbPassword = "ssdi";
    		
    			Class.forName("com.mysql.jdbc.Driver");
    			Connection con = DriverManager.getConnection(url, dbUsername, dbPassword); 
                String query = "SELECT * FROM employee WHERE empId="+empId; 
       
    			PreparedStatement ps = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data

    			ResultSet rs = ps.executeQuery();
    			
    			if(rs.next()) {
    				employeeBean.setFirstName(rs.getString("firstName"));
    				employeeBean.setMiddleName(rs.getString("middleName"));
    				employeeBean.setLastName(rs.getString("lastName"));
    				employeeBean.setBirthDate(rs.getString("birthdate"));
    				employeeBean.setGender(rs.getString("gender"));
    				employeeBean.setPhoneNumber(rs.getString("phoneNumber"));
    				employeeBean.setEmail(rs.getString("email"));
    				employeeBean.setSsn(rs.getString("ssn"));
    				employeeBean.setHighestEducation(rs.getString("highestEducation"));
    				employeeBean.setDesignation(rs.getString("designation"));
    				employeeBean.setEffectiveDate(rs.getString("effectiveDate"));
    				employeeBean.setJoiningDate(rs.getString("joiningDate"));
    				employeeBean.setJoiningPosition(rs.getString("joiningPosition"));
    				employeeBean.setEmploymentType(rs.getString("employmentType"));
    				employeeBean.setManagerId(rs.getString("managerId"));
    				employeeBean.setDepartmentName(rs.getString("departmentName"));
    				employeeBean.setProject(rs.getString("project"));
    			}
    			rs.close();
    			ps.close();
    			   
    		}
     catch(SQLException e)
     {
        e.printStackTrace();
     }
        return employeeBean;  
 }
	
	public String editEmployeeDetails(EmployeeBean employeeBean) throws Exception
    {
		int empId = employeeBean.getEmployeeId();
        String firstName = employeeBean.getFirstName();
        String middleName = employeeBean.getMiddleName();
        String lastName = employeeBean.getLastName();
        String birthDate = employeeBean.getBirthDate();
        String gender = employeeBean.getGender();
        String phoneNumber = employeeBean.getPhoneNumber();
        String email = employeeBean.getEmail();
        String ssn = employeeBean.getSsn();
        String highestEducation = employeeBean.getHighestEducation();
        String designation = employeeBean.getDesignation();
        String effectiveDate = employeeBean.getEffectiveDate();
        String joiningDate = employeeBean.getJoiningDate();
        String joiningPosition = employeeBean.getJoiningPosition();
        String employementType = employeeBean.getEmploymentType();
        String managerId = employeeBean.getManagerId();
        String departmentName = employeeBean.getDepartmentName();
        String project = employeeBean.getProject();        
        
        PreparedStatement ps = null;
        try
        {
       		String url = "jdbc:mysql://localhost:3306/timekeepersystem";
       		String dbUsername = "admin";
       		String dbPassword = "ssdi";
       		
       			Class.forName("com.mysql.jdbc.Driver");
       			Connection con = DriverManager.getConnection(url, dbUsername, dbPassword); 

            String query = "UPDATE employee SET firstName=?,middleName=?,lastName=?,birthDate=?,gender=?,phoneNumber=?,email=?,ssn=?,"
            		+ "highestEducation=?,designation=?,effectiveDate=?,joiningDate=?,joiningPosition=?,employmentType=?,managerId=?,"
            		+ "departmentName=?, project=? WHERE empId="+empId; 
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
	
}