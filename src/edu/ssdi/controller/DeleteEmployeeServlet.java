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

import edu.ssdi.model.DeleteEmployeeDao;


@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteEmployeeServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int empId = Integer.parseInt(request.getParameter("empId"));
		
		String detailDeleted = null;
		DeleteEmployeeDao deleteDao = new DeleteEmployeeDao();
		
		try {
			detailDeleted = deleteDao.deleteEmployee(empId);
			
			if(detailDeleted.equals("SUCCESS"))   //On success, you can display a message to user on Home page
	         {
				request.getRequestDispatcher("/ListPreviousEmployee.jsp").forward(request, response);
	         }
	         else   //On Failure, display a meaningful message to the User.
	         {
	            request.setAttribute("errMessage", detailDeleted);
	            request.getRequestDispatcher("/Error.jsp").forward(request, response);
	         }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
