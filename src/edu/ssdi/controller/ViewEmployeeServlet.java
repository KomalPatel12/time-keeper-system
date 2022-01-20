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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssdi.model.EditEmployeeDao;

@WebServlet("/ViewEmployeeServlet")
public class ViewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ViewEmployeeServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("ViewEmployee.jsp");
			request.setAttribute("employeeOld", EditEmployeeDao.getEmployeeDetails(empId));
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
