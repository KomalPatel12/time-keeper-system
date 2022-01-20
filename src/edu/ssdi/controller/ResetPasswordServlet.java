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
import edu.ssdi.model.ResetPasswordDao;

@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResetPasswordServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("employeeid");
		String newPassword = request.getParameter("newpassword");
		
		EmployeeBean employeeBean = new EmployeeBean();
        
        employeeBean.setEmployeeId(Integer.parseInt(empId));
        employeeBean.setNewPassword(newPassword);
        
        ResetPasswordDao resetPasswordDao = new ResetPasswordDao();
        String detailSaved;
		try {
			detailSaved = resetPasswordDao.resetPassword(employeeBean);
			if(detailSaved.equals("SUCCESS"))   //On success, you can display a message to user on Home page
	         {
	            request.getRequestDispatcher("/index.jsp").forward(request, response);
	         }
	         else   //On Failure, display a meaningful message to the User.
	         {
//	            request.setAttribute("errMessage", detailSaved);
//	            request.getRequestDispatcher("/Error.jsp").forward(request, response);
	         }
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}


