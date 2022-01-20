<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
</head>
<body>
 <jsp:include page="Header.jsp">
       <jsp:param name="title" value="Main title" />
    </jsp:include>
 <div align="center">
  <div class ="LoginH1"><h1>Employee Login Form</h1> </div>
  <div class="wrap-login100">
 
  <form class ="login100-form" action="LoginServlet" method="post">
  <div class="6u 12u$(4)">
  
     <label for="uname">Username</label>
    <input class="input100" type="text" placeholder="Enter Username" name="username" required>
    <span class="focus-input100" data-placeholder="&#xf207;"></span>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
        

   <!--   <table>
     <td>UserName</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
 
   </table>-->
   </div>
   <input type="submit" value="Submit" />
  </form>
  </div>
 </div>
</body>
</html>

	<!-- Footer -->
			 <jsp:include page="Footer.jsp">
       <jsp:param name="title" value="Footer" />
    </jsp:include>