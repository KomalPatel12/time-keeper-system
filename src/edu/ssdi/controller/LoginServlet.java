package edu.ssdi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ssdi.bean.EmployeeBean;
import edu.ssdi.bean.LoginBean;
import edu.ssdi.controller.AddServlet;
import edu.ssdi.model.LoginDao;



//process HTTP page parameters and redirect to appropriate page: login success

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        try {
        	Integer empId =  loginDao.validate(loginBean);
            if (empId!=0 ) {
            	EmployeeBean emp = loginDao.getUserEmp(empId);
            	
            	String firstName = emp.getFirstName();
            	String roleId = emp.getRoleId();
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
    	        session.setAttribute("empId", empId);
    	        session.setAttribute("roleId", roleId);
    	        session.setAttribute("firstName", firstName);
    	        System.out.println(firstName + roleId);

                RequestDispatcher dispatcher = request.getRequestDispatcher("ClockInTime");
    	        
    	        dispatcher.forward(request, response);
    	       
               // response.sendRedirect("index.jsp");
            } else {
                HttpSession session = request.getSession();
                //session.setAttribute("user", username);
                response.sendRedirect("Login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}