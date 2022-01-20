<!-- /* ******************
 * 
 * 
 Author: Komal Patel
 * 
 *
 ********************/ -->
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<style>

.form-control, .btn {
    min-height: 38px;
    border-radius: 2px;
}
.btn {        
    font-size: 15px;
    font-weight: bold;
}
</style>

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="background-color:#383b43; font-size:15px; height:100px">
			
		<i class="fa fa-clock-o" aria-hidden="true" style="font-size: 24px; color: white"> </i> 
  		<a class="navbar-brand" href="#">TimeKeeper System</a>

  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      	<li class="nav-item active">
        	<a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
     	<li class="nav-item">
      		<a class="nav-link" href="ColockInTime">Time-In/Out</a></li>
      <li class="nav-item">
        <a class="nav-link" href="Emp_Calendar">Calendar</a>
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
        <a class="nav-link" href="Login.">Logout</a>
      </li>
    </ul>
  </div>
</nav>

<h1 align="center" style="color:#383b43"> Edit Employee Details</h1><br>


<form action="EditEmployeeServlet" method="post" onsubmit="return validate()">
    <div class="container" style="max-width: 1600px;">
			<div class="row">
				<div class="col" style="float: left;">
					<div class="form-group">
						<h3>Personal Details</h3>
					</div>

        <div class="form-group ">
            <label for="firstname"><b>First name:<label style="color:red">*</label></b></label><br>            
            <input type="text" name="firstname" class="form-control" required="required" value="<c:out value='${employeeOld.firstName }' />">
        </div>
        
        <div class="form-group">
			<label for="middlename"><b>Middle name:</b></label>
            <input type="text" name="middlename" class="form-control" value="<c:out value='${employeeOld.middleName }' />" >
        </div>
        <div class="form-group">
			<label for="lastname"><b>Last name:<label style="color:red">*</label></b></label><br>
            <input type="text" name="lastname" class="form-control" value="<c:out value='${employeeOld.lastName }' />"  required="required">
        </div>
       <div class="form-group">
			<label for="birthdate"><b>Birth Date:<label style="color:red">*</label></b></label><br>
            <input type="text" name="birthdate"  class="form-control" value="<c:out value='${employeeOld.birthDate }' />"  required="required">
        </div>
		
		<div class="form-group">
			<label for="gender"><b>Gender:<label style="color:red">*</label></b></label><br> 
			<select name="gender" class="form-control" placeholder="Gender" required="required">
				<option><c:out value='${employeeOld.gender }' /></option> 
				<option value="male">Male</option>
				<option value="female">Female</option>
			</select>
		</div>
					
		<div class="form-group">
			<label for="phonenumber"><b>Phone number:<label style="color:red">*</label></b></label><br> 
			<input type="text" name="phonenumber" class="form-control" value="<c:out value='${employeeOld.phoneNumber }' />"   required="required">
		</div>
		
		<div class="form-group">
			<label for="email"><b>Email address:<label style="color:red">*</label></b></label><br> 
			<input type="email" name="email" class="form-control" value="<c:out value='${employeeOld.email }' />" required="required">
		</div>
					
		<div class="form-group">
			<label for="highesteducations"><b>Choose Highest Education:<label style="color:red">*</label></b></label><br> 
			<select name="highesteducations" class="form-control" required="required">
				<option><c:out value='${employeeOld.highestEducation }' /></option> 
				<option value="doctorate">Doctorate</option>
				<option value="masters">Graduate</option>
				<option value="bachelorette">Undergraduate</option>
				<option value="associate">Associate</option>
				<option value="certification">Certificate</option>
				<option value="highschool">High School</option>
				<option value="other">Other</option>
			</select>
		</div>
		
		<div class="form-group">
			<label for="ssn"><b>SSN:<label style="color:red">*</label></b></label><br> 
			<input type="text" name="ssn" pattern="^\d{3}-\d{2}-\d{4}$" class="form-control" value="<c:out value='${employeeOld.ssn }' />" required="required">
		</div>
			
		</div>
			
		<div class="col" style="float: left;">
			<div class="form-group">
				<h3>Employment Details</h3>
			</div>
			
			<div class="form-group ">
            	<label for="employeeid"><b>Employee Id:<label style="color:red">*</label></b></label><br>
           		<input type="text" name="employeeid" class="form-control" value=<%= request.getParameter("empId")%> required="required" readonly>
        	</div>		
        						
			<div class="form-group">
				<label for="designation"><b>Designation:<label style="color:red">*</label></b></label> 
				<input type="text" name="designation" class="form-control" value="<c:out value='${employeeOld.designation }' />">
			</div>
			
			<div class="form-group">
				<label for="effectivedate"><b>Effective Date:</b></label> 
				<input type="text" name="effectivedate" class="form-control" value="<c:out value='${employeeOld.effectiveDate }' />">
			</div>
					
			<div class="form-group">
				<label for="joiningdate"><b>Joining Date:<label style="color:red">*</label></b></label><br> 
				<input type="text" name="joiningdate" id="joiningDate" class="form-control" value="<c:out value='${employeeOld.joiningDate }' />" onblur="ValidateDateFormat()" required="required">
			</div>
			
			<div class="form-group">
				<label for="joiningposition"><b>Joining Position:<label style="color:red">*</label></b></label><br> 
				<input type="text" name="joiningposition" class="form-control" value="<c:out value='${employeeOld.joiningPosition }' />" required="required">
			</div>

			<div class="form-group">
				<label for="employeetype]"><b>Employment Type:<label style="color:red">*</label></b></label><br> 
				<input type="text" name="employmenttype" class="form-control" value="<c:out value='${employeeOld.employmentType }' />" required="required">
			</div>
			
			<div class="form-group">
				<label for="managerid"><b>Manager Id:<label style="color:red">*</label></b></label><br> 
				<input type="text" name="managerid" class="form-control" value="<c:out value='${employeeOld.managerId }' />" required="required">
			</div>
			
			<div class="form-group">
				<label for="departmentname"><b>Department Name:<label style="color:red">*</label></b></label><br> 
				<input type="text" name="departmentname" class="form-control" value="<c:out value='${employeeOld.departmentName }' />" required="required">
			</div>
			
			<div class="form-group">
				<label for="project"><b>Project:</b></label><br> 
				<input type="text" name="project" class="form-control" value="<c:out value='${employeeOld.project }' />" required="required">
			</div>
			
		</div>
	</div>

        <div class="row">
			<div class="mx-auto" style="width:200px; margin-top:20px;">
				<button type="submit" class="btn btn-primary btn-block">Update Details</button><br>
			</div>
		</div>
</div>
      
         <%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%>
        
    
        </form>
</body>
</html>