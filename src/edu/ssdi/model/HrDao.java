/****************************Author : Akanksha Gupta ****************************************/
package edu.ssdi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ssdi.bean.EmpTimekeeper;
import edu.ssdi.bean.EmployeeBean;
import edu.ssdi.util.Database;

public class HrDao {
	private Connection connection;
	  
    public HrDao() {
        connection = Database.getConnection();

}
    
    public List<EmpTimekeeper> getOrgTime(String departmentName) {
        //List<Employee> org = new ArrayList<Employee>();
        List<EmpTimekeeper> tk = new ArrayList<EmpTimekeeper>();
        
        try {
           
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT t.empId , DATE_FORMAT(t.tkDate, \"%m/%d/%Y\") as tkDate,\r\n"
            		+ "DATE_FORMAT(t.timeIn,\"%r\") as timeIn, \r\n"
            		+ "DATE_FORMAT(t.timeOut, \"%r\") as timeOut\r\n"
            		+ "FROM EmpTimekeeper t, addemp e\r\n"
            		+ "WHERE e.departmentName= ?\r\n"
            		+ "AND e.empId = t.empId\r\n"
            		+ "ORDER BY t.empID, tkDate");
            preparedStatement.setString(1, departmentName);
            //System.out.println(managerId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                
                EmpTimekeeper emptm = new EmpTimekeeper();
                emptm.setEmpId(rs.getInt("empId"));
                emptm.setTimeIn(rs.getString("timeIn"));
                emptm.setTimeOut(rs.getString("timeOut"));
                emptm.setTkDate(rs.getString("tkDate"));
                tk.add(emptm);
               System.out.println(rs.getInt("empId"));
               
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
       return tk;
    }
 
    public List<EmployeeBean> getOrg() {
        List<EmployeeBean> org = new ArrayList<EmployeeBean>();
        
        try {
           
            PreparedStatement preparedStatement = connection.prepareStatement("Select empId, concat(firstName,\" \", lastName) as Name , designation, departmentName from Employee\r\n");
            //preparedStatement.setInt(1, managerId);
            //System.out.println(managerId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                EmployeeBean emp = new EmployeeBean();
                emp.setEmployeeId(rs.getInt("empId"));
                emp.setFullName(rs.getString("Name"));
                emp.setDesignation(rs.getString("designation"));
                emp.setDepartmentName(rs.getString("departmentName"));
              //  System.out.println(rs.getInt("empId"));
                org.add(emp);
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
       return org;
    }
   
}