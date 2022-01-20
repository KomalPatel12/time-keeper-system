package edu.ssdi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssdi.model.TITO_Handler;

/**
 * Servlet implementation class ResolveRequest
 */
@WebServlet("/ResolveRequest")
public class ResolveRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResolveRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postID = Integer.parseInt(request.getParameter("reqid"));
		
		TITO_Handler th = new TITO_Handler();
		
		 String ar_stat = request.getParameter("ar_stat");
		 
		 if(ar_stat.equals("approve"))
		 {
			 System.out.println("Approved");
		 }else if(ar_stat.equals("reject"))
		 {
			 System.out.println("Rejected");
		 }else
		 {
			 System.out.println("Nothing selected");
		 }
		
		
		
		
		
		doGet(request, response);
	}

}
