<!-- ****************************Author : Akanksha Gupta **************************************** -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.io.*, java.util.*, javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>ClockInTime </title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
		
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<style>
		        <%@include file="css/style.css" %>
		     <%@include file="css/skel.css" %>
		     <%@include file="css/style-xlarge.css" %>
		
		</style>
		 <!-- <style>
		    
			<link rel="stylesheet" href="css/skel.css" >
			<link rel="stylesheet" href="css/style.css" >
			<link rel="stylesheet" href="css/style-xlarge.css" > 
		</style> -->
		
	
	</head>
	<body>
			 <jsp:include page="Header.jsp">
       <jsp:param name="title" value="Main title" />
    </jsp:include>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="container">

					<header class="major">
						<h2>Welcome <c:out value="${firstName}" />!</h2>
					
				
						<!--<p>In and Out Time for a day</p>-->
					</header>

				<section id="one" class="wrapper style1 special">
				<div class="container">
					
					<div class="row 150%">
					
						<div class="4u 12u$(medium)">
							<a href="timein"><section class="box">
								<i class="icon big rounded color1 fas fa-clock"></i>
								
								<h3>Time in</h3>
							  
								<p> <c:out value="${Emptk.timeIn}" /></p>
							
						
							  
								
							</section> </a>
						 </div>
						
						
						    <div class="4u 12u$(medium)">
							<section class="box">
								 <i class="icon big rounded color9 fas fa-arrows-alt"></i>
								
								
								
												<H3>Current Time</H3>
												
	<%
        Date date = new Date();
         out.print( "<p align = \"center\">" +date.toString()+"</p>");
      %>
							</section>
						    </div> 
						
							<div class="4u 12u$(medium)">
							<section class="box">
							<a href="timeout">
								<i class="icon big rounded color6 fas fa-clock"></i>
								
								<h3>Time Out</h3>
								<p><c:out value="${Emptk.timeOut}" /></p>
							</a> 
							</section> 
						    </div>
							
					   </div>
				</div>
			</section>

			
					

				</div>
			</section>

		<!-- Footer -->
			<!-- Footer -->
			 <jsp:include page="Footer.jsp">
       <jsp:param name="title" value="Footer" />
    </jsp:include>

	</body>
</html>



