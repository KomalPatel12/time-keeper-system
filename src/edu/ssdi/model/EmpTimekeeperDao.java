package edu.ssdi.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.ssdi.bean.EmpTimekeeper;
import edu.ssdi.bean.EmployeeBean;
import edu.ssdi.util.Database;

public class EmpTimekeeperDao {
	  private Connection connection;
	  
	    public EmpTimekeeperDao() {
	        connection = Database.getConnection();
	    }
	    public void checkTimeIn(EmpTimekeeper emptk) {
	    	
	        try {
		    

	            PreparedStatement ps = connection.prepareStatement("select * from EmpTimekeeper where tkDate = ? and empId =?");
	            
	            ps.setString(1, emptk.getTkDate());
	            ps.setInt(2, emptk.getEmpId());
	            ResultSet rs = ps.executeQuery();
	         //   System.out.println(((Object) rs).getEmpID());  
	            if (rs.next()) // found
	            {
	                
	            	System.out.println("TimeIn already exist");
	            	
	            	//addTimeout(emptk);
	                
	            } 
	            else {
	                addTimein(emptk);
	            }
	          
	        } catch (Exception ex) {
	            System.out.println("Error in check() -->" + ex.getMessage());
	        } 
	   
	    }
	    public void checkTimeOut(EmpTimekeeper emptk) {
	        try {
	            PreparedStatement ps = connection.prepareStatement("select * from EmpTimekeeper where tkDate = ? and empId =?");
	            ps.setInt(2, emptk.getEmpId());
	            ps.setString(1, emptk.getTkDate());
	            ResultSet rs = ps.executeQuery();
	          //  String timeout= rs.getString("timeOut");
	          //  System.out.println(timeout);
	           
	            if ((rs.next())) // found
	            {
	            	
	                System.out.println("TimeIn exist");
	                addTimeout(emptk);
	            	//addTimeout(emptk);
	            	
	                
	            } 
	            else {
	               // addTimein(emptk);
	                System.out.println("No Time In for the day");
	            }
	        } catch (Exception ex) {
	            System.out.println("Error in check() -->" + ex.getMessage());
	        } 
	    }
	    public void addTimeout(EmpTimekeeper emptk) {
			// TODO Auto-generated method stub
	    	try {
	    	PreparedStatement ps = connection.prepareStatement("Update emptimekeeper set timeOut = ? where empId = ? and tkDate =?");
	    	
          //  ps.setString(2, emptk.getTimeIn());
            ps.setString(1, emptk.getTimeOut());
            ps.setInt(2, emptk.getEmpId());
            ps.setString(3, emptk.getTkDate());
	            int i = ps.executeUpdate();
	            if (i > 0)
	                System.out.print("Time_out updated..");
			
		}
	    	catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		public void addTimein(EmpTimekeeper emptk) {
			// TODO Auto-generated method stub
			try {
			 PreparedStatement ps = connection.prepareStatement("insert into EmpTimekeeper (empId, timeIn, timeOut, tkDate)values(?,?,?,?)");
	 
	            ps.setInt(1, emptk.getEmpId());
	            ps.setString(2, emptk.getTimeIn());
	            ps.setString(3, emptk.getTimeOut());
	            ps.setString(4, emptk.getTkDate());
	 
	            int i = ps.executeUpdate();
	            if (i > 0)
	                System.out.print("Time In updated...");
		}
			catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		
		
	 
	   public EmpTimekeeper getTime(EmpTimekeeper emptk)
	   {
		   try {
	            PreparedStatement ps = connection.prepareStatement("select * from EmpTimekeeper where tkDate = ? and empId =?");
	            ps.setString(1, emptk.getTkDate());
	            ps.setInt(2, emptk.getEmpId());

	            ResultSet rs = ps.executeQuery();
	          //  String timeout= rs.getString("timeOut");
	          //  System.out.println(timeout);
	           
	            if ((rs.next())) // found
	            {
	            	
	                System.out.println("Time exist");
	                emptk.setEmpId(rs.getInt("empId"));
	                emptk.setTimeIn(rs.getString("timeIn"));
	                emptk.setTimeOut(rs.getString("timeOut"));
	                emptk.setTkDate(rs.getString("tkDate"));
	                //return emptk;
	            	//addTimeout(emptk);
	            	
	                
	            } 
	            else {
	               // addTimein(emptk);
	                System.out.println("No Time Exist for the day");
	            }
	        } catch (Exception ex) {
	            System.out.println("Error in check() -->" + ex.getMessage());
	        }
		return emptk; 
		 
		   
	   }
	 
	    
	 
	   
	    public List<EmpTimekeeper> getEmployeeTime(int empId) {
	        List<EmpTimekeeper> emptk = new ArrayList<EmpTimekeeper>();
	        
	        try {
	           
	            PreparedStatement preparedStatement = connection.prepareStatement("SELECT empId, \r\n"
	            		+ "		DATE_FORMAT(tkDate, \"%m/%d/%Y\") as tkDate,\r\n"
	            		+ " 		DATE_FORMAT(timeIn, \"%r\") as timeIn,  \r\n"
	            		+ " 		DATE_FORMAT(timeOut, \"%r\") as timeOut,\r\n"
	            		+ "        time_format(timediff(timeOut, timeIn), \"%H hr %i min\") as duration\r\n"
	            		+ "		FROM EmpTimekeeper\r\n"
	            		+ "        WHERE empId=?");
	            preparedStatement.setInt(1, empId);
	            //System.out.println(managerId);
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	                EmpTimekeeper emp = new EmpTimekeeper();
	                emp.setEmpId(rs.getInt("empId"));
	                emp.setTkDate(rs.getString("tkdate"));
	                emp.setTimeIn(rs.getString("timeIn"));
	                emp.setTimeOut(rs.getString("timeOut"));
	                emp.setDuration(rs.getString("duration"));
	              //  System.out.println(rs.getInt("empId"));
	                emptk.add(emp);
	              
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 
	       return emptk;
	    }
	 

}