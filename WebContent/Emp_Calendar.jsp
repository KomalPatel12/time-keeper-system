<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<title>ClockInTime </title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
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
	
	</head>
	<body>
	

			<!-- Header -->
		 <jsp:include page="Header.jsp">
       <jsp:param name="title" value="Main title" />
    </jsp:include>

		<!-- Main -->
			<section id="main" class="wrapper">
			<div class="container">
			<section>
							
						
							<Div class="table-header" >Historical Time</Div>
							<div class="table-wrapper">
								<table class="alt">
									<thead>
										<tr>
											<th> Date</th>
											<th> Time In</th>
											<th> Time Out</th>
											<th> Duration </th>
										</tr>
									</thead>
									<tbody>
									
										<c:forEach var="time" items="${listEmpTime}">
              						  <tr>
                    				<td><c:out value="${time.tkDate}" /></td>
                				    <td><c:out value="${time.timeIn}" /></td>
             				       <td><c:out value="${time.timeOut}" /></td>
            				        <td><c:out value="${time.duration}" /></td>
        					        </tr>
         						   </c:forEach>
										
									</tbody>
									<tfoot>
									</tfoot>
								</table>
							</div>
						</section>
				</div>
			</section>

		</body>	

		<!-- Footer -->
			 <jsp:include page="Footer.jsp">
       <jsp:param name="title" value="Footer" />
    </jsp:include>
		

	
</html>