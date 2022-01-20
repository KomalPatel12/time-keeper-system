<!-- /* ******************
 * 
 * 
 Author: Komal Patel
 * 
 *
 ********************/ -->
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<title>List All Employee</title>

<style>
table, th, td {
  border: 1px solid black;
}
.padding-icon {
	padding-left:15px;
	font-size:24px;
}
</style>
</head>

<body>
<sql:setDataSource
        var="listDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/timekeepersystem"
        user="admin" password="ssdi" />
     
    <sql:query var="listEmployees" dataSource="${listDS}">
        SELECT * FROM timekeepersystem.employee WHERE currentEmployee=1 ORDER BY empId DESC;
    </sql:query>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="background-color:#383b43; font-size:15px; height:100px">
			
		<i class="fa fa-clock-o" aria-hidden="true" style="font-size: 24px; color: white"> </i> 
  		<a class="navbar-brand" href="#">TimeKeeper System</a>

  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ColockInTime.jsp">Time-In/Out</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Emp_Calendar.jsp">Calendar</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Employee Details
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="AddEmployee.jsp">Add New Employee</a>
          <a class="dropdown-item" href="ListEmployee.jsp">All Current Employees</a>
          <a class="dropdown-item" href="ListPreviousEmployee.jsp">Previous Employee</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Login.jsp">Logout</a>
      </li>
    </ul>
  </div>
</nav>

<form>
<br>
<h1 align="center" style="color:#383b43"> List of all Current Employees</h1><br>

   <div align="center">
   
        <table border="1" cellpadding="5" class="table table-striped table-hover table-bordered">
        <thead class="thead-dark">
            <tr>
            	<th id="empNo">No.</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone Number</th>
                <th>Email</th>
                <th>SSN</th>
                <th>Employment Type</th>
                <th>Designation</th>
                <th>Project</th>
                <th><center>Action</center></th>
            </tr>
            </thead>
            <c:forEach var="employee" items="${listEmployees.rows}">
                <tr>
                	<td><c:out value="${employee.empId}" /></td>
                    <td><c:out value="${employee.firstName}" /></td>
                    <td><c:out value="${employee.lastName}" /></td>
                    <td><c:out value="${employee.phoneNumber}" /></td>
                    <td><c:out value="${employee.email}" /></td>
					<td><c:out value="${employee.ssn}" /></td>
					<td><c:out value="${employee.employmentType }" /></td>
					<td><c:out value="${employee.designation}" /></td>
					<td><c:out value="${employee.project}" /></td>
					<td>
                    	<a href="ViewEmployeeServlet?empId=<c:out value='${employee.empId}' />"><i class="fa fa-eye padding-icon"></i></a>
                    	<a href="EditEmployeeServlet?empId=<c:out value='${employee.empId}' />"><i class="fa fa-edit padding-icon"></i></a>                
 						<a href="DeleteEmployeeServlet?empId=<c:out value='${employee.empId}' />"><i class="fa fa-trash padding-icon"></i></a>
 					</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
</body>
</html> 