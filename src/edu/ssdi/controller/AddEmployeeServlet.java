/* ******************
 * 
 * 
 Author: Komal Patel
 	This class defines controller(Servlet) for Add Employee details.
 * 
 *
 ********************/

package edu.ssdi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssdi.bean.EmployeeBean;
import edu.ssdi.model.AddEmployeeDao;

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Retrieve value of each parameter in local variables
         String firstName = request.getParameter("firstname");
         String middleName = request.getParameter("middlename");
         String lastName = request.getParameter("lastname");
         String birthDate = request.getParameter("birthdate");
         String gender = request.getParameter("gender");
         String phoneNumber = request.getParameter("phonenumber");
         String email = request.getParameter("email");
         String ssn = request.getParameter("ssn");
         String highestEducation = request.getParameter("highesteducations");
         String designation = request.getParameter("designation");
         String effectiveDate = request.getParameter("effectivedate");
         String joiningDate = request.getParameter("joiningdate");
         String joiningPosition = request.getParameter("joiningposition");
         String employmentType = request.getParameter("employmenttype");
         String managerId = request.getParameter("managerid");
         String departmentName = request.getParameter("departmentname");
         String project = request.getParameter("project");
         
         EmployeeBean employeeBean = new EmployeeBean();
        //Set value of each variable to store
         employeeBean.setFirstName(firstName);
         employeeBean.setMiddleName(middleName);
         employeeBean.setLastName(lastName);
         employeeBean.setBirthDate(birthDate);
         employeeBean.setGender(gender);
         employeeBean.setPhoneNumber(phoneNumber);
         employeeBean.setEmail(email);
         employeeBean.setSsn(ssn);
         employeeBean.setHighestEducation(highestEducation);
         employeeBean.setDesignation(designation);
         employeeBean.setEffectiveDate(effectiveDate);
         employeeBean.setJoiningDate(joiningDate);
         employeeBean.setJoiningPosition(joiningPosition);
         employeeBean.setEmploymentType(employmentType);
         employeeBean.setManagerId(managerId);
         employeeBean.setDepartmentName(departmentName);
         employeeBean.setProject(project);
         
         AddEmployeeDao employeeDao = new AddEmployeeDao();
         
         String detailSaved;
		try {
			//Insert data into database
			detailSaved = employeeDao.addNewUser(employeeBean);
			employeeDao.createCredentials();
			if(detailSaved.equals("SUCCESS"))   
	         {
				//redirection if data insertion performed successfully
	            request.getRequestDispatcher("/ListEmployee.jsp").forward(request, response);
	         }
	         else   
	         {
	        	//redirection if some error occurred.
	            request.setAttribute("errMessage", detailSaved);
	            request.getRequestDispatcher("/Error.jsp").forward(request, response);
	         }
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
}
