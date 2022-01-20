/****************************Author : Akanksha Gupta ****************************************/
package edu.ssdi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ssdi.bean.EmployeeBean;
import edu.ssdi.util.Database;

public class TeamDao {
	private Connection connection;
	  
    public TeamDao() {
        connection = Database.getConnection();
}
   
    public List<EmployeeBean> getTeam(int managerId) {
        List<EmployeeBean> team = new ArrayList<EmployeeBean>();
        
        try {
           
            PreparedStatement preparedStatement = connection.prepareStatement("Select empId, concat(firstName,\" \", lastName) as Name , designation, departmentName from Employee\r\n"
            		+ "where managerID = ?");
            preparedStatement.setInt(1, managerId);
            //System.out.println(managerId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                EmployeeBean emp = new EmployeeBean();
                emp.setEmployeeId(rs.getInt("empId"));
                emp.setFullName(rs.getString("Name"));
                emp.setDesignation(rs.getString("designation"));
                emp.setDepartmentName(rs.getString("departmentName"));
              //  System.out.println(rs.getInt("empId"));
                team.add(emp);
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
       return team;
    }
 
   

}