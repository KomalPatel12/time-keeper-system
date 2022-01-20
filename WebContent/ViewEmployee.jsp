<!-- /* ******************
 * 
 * 
 Author: Komal Patel
 * 
 *
 ********************/ -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
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

<title>View Employee Details</title>

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
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="background-color:#383b43; font-size:15px; height:100px">
			
		<i class="fa fa-clock-o" aria-hidden="true" style="font-size: 24px; color: white"> </i> 
  		<a class="navbar-brand" href="#">TimeKeeper System</a>

  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <div></div><li class="nav-item active">
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
        <a class="nav-link" href="Login.jsp" style="float:right">Logout</a>
      </li>
    </ul>
  </div>
</nav>

<h1 align="center" style="color:blue"> View Employee Details</h1><br>

<form>
    <div class="container" style="max-width: 1600px;">
			<div class="row">
				<div class="col" style="float: left;">
					<div class="form-group">
						<h3>Personal Details</h3>
					</div>
					    
        <div class="form-group ">
            <label for="firstname"><b>First name:</b></label>          
            <c:out value='${employeeOld.firstName }' />
        </div>
        
        <div class="form-group ">
            <label for="middlename"><b>Middle name:</b></label>          
            <c:out value='${employeeOld.middleName }' />
        </div>
        
        <div class="form-group ">
            <label for="lastname"><b>Last name:</b></label>          
            <c:out value='${employeeOld.lastName }' />
        </div>
        
        <div class="form-group ">
            <label for="birthdate"><b>Birth Date:</b></label>          
            <c:out value='${employeeOld.birthDate }' />
        </div>
        
        <div class="form-group ">
            <label for="gender"><b>Gender:</b></label>          
            <c:out value='${employeeOld.gender }' />
        </div>
        
        <div class="form-group ">
            <label for="phonenumber"><b>Phone number:</b></label>          
            <c:out value='${employeeOld.phoneNumber }' />
        </div>

		<div class="form-group ">
            <label for="email"><b>Email address:</b></label>          
            <c:out value='${employeeOld.email }' />
        </div>
					
		<div class="form-group ">
            <label for="highesteducations"><b>Highest Education:</b></label>          
            <c:out value='${employeeOld.highestEducation }' />
        </div>
        
        <div class="form-group ">
            <label for="ssn"><b>SSN:</b></label>          
            <c:out value='${employeeOld.ssn }' />
        </div>	
		</div>
			
		<div class="col" style="float:left">
			<div class="form-group">
				<h3>Employment Details</h3>
			</div>
			
	<div class="form-group ">
            	<label for="employeeid"><b>Employee Id:</b></label>
	        	<%= request.getParameter("empId")%>
        	</div>		
			
		<div class="form-group ">
            <label for="designation"><b>Designation:</b></label>          
            <c:out value='${employeeOld.designation }' />
        </div>
        
        <div class="form-group ">
            <label for="effectivedate"><b>Effective Date:</b></label>          
            <c:out value='${employeeOld.effectiveDate }' />
        </div>
        
        <div class="form-group ">
            <label for="joiningdate"><b>Joining Date:</b></label>          
            <c:out value='${employeeOld.joiningDate }' />
        </div>
       
        <div class="form-group ">
            <label for="joiningposition"><b>Joining Position:</b></label>          
            <c:out value='${employeeOld.joiningPosition }' />
        </div>
        
        <div class="form-group ">
            <label for="employmenttype"><b>Employment Type:</b></label>          
            <c:out value='${employeeOld.employmentType }' />
        </div>
        
		<div class="form-group ">
            <label for="managerid"><b>Manager Id:</b></label>          
            <c:out value='${employeeOld.managerId }' />
        </div>
        
        <div class="form-group ">
            <label for="departmentname"><b>Department Name:</b></label>          
            <c:out value='${employeeOld.departmentName }' />
        </div>
        
        <div class="form-group ">
            <label for="project"><b>Project:</b></label>          
            <c:out value='${employeeOld.project }' />
        </div>
			
		</div>
	</div>

        <div class="row">
			<div class="mx-auto" style="width:200px; margin-top:20px;">
				<a href="EditEmployeeServlet?empId=<%= request.getParameter("empId")%>" class="btn btn-primary btn-block">Edit Details</a><br>
			</div>
		</div>
</div>
      
         <%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%>
        
    
</form>
</body>
</html> 