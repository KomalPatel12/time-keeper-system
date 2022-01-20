<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title> TimeKeeper </title>
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
 
		<!-- Header -->
		 <jsp:include page="Header.jsp">
       <jsp:param name="title" value="Main title" />
    </jsp:include>

		<!-- Main -->
		<section id="banner">
		       
				<h2> TimeKeeper System</h2>
				<p> Clock in your time</p>
				<ul class="actions">
					
						
						
						<%if((session.getAttribute("username")== null) )	{ %>	
				
						
						
						<a href="IndexServlet" class="button big">Log In</a>
						
				<% } %>
					
				</ul> 
			</section>
		

		<!-- Footer -->
			 <jsp:include page="Footer.jsp">
       <jsp:param name="title" value="Footer" />
    </jsp:include>

	</body>
</html>


