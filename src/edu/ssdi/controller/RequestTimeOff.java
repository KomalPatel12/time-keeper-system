package edu.ssdi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

import edu.ssdi.model.TITO_Handler;

/**
 * Servlet implementation class RequestTimeOff
 */
@WebServlet("/RequestTimeOff")
public class RequestTimeOff extends HttpServlet {
	private static final long serialVersionUID = 1L;
	long requestID;
	int employeeID;
	Date oldTime;
	Date newTime;
	String reason;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestTimeOff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Time In/Time Out request submitted.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sqlDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		oldTime = sqlDateFormat.parse(request.getParameter("olddate") + " " + request.getParameter("oldtime"), new ParsePosition(0));
		newTime = sqlDateFormat.parse(request.getParameter("newdate") + " " + request.getParameter("newtime"), new ParsePosition(0));
		
		
		System.out.println("Date format is: " + request.getParameter("olddate") + " " + request.getParameter("oldtime"));
		employeeID = 0; //TODO
		
		reason = request.getParameter("reason");
		TITO_Handler tHandler = new TITO_Handler();
		
		System.out.println("Values are " + oldTime + "/" + newTime);
		
		tHandler.makeRequest(oldTime, newTime, reason);
		System.out.println("done here");
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
