package edu.ssdi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssdi.bean.EmployeeBean;
import edu.ssdi.model.CreateCredentialDao;
import edu.ssdi.model.ResetPasswordDao;

@WebServlet("/CreateCredentialServlet")
public class CreateCredentialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateCredentialServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("employeeid");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		EmployeeBean employeeBean = new EmployeeBean();
        
//        employeeBean.setEmployeeId(Integer.parseInt(empId));
		employeeBean.setUsername(userName);
        employeeBean.setPassword(password);
        
        CreateCredentialDao createCredentialDao = new CreateCredentialDao();
        String detailSaved;
		try {
			detailSaved = createCredentialDao.createCredential(Integer.parseInt(empId));
			if(detailSaved.equals("SUCCESS"))   //On success, you can display a message to user on Home page
	         {
	            request.getRequestDispatcher("/ListEmployee.jsp").forward(request, response);
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


