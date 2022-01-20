<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Reset Password</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<script type="text/javascript">
var password = document.getElementById("newpassword").value;
var confirm_password = document.getElementById("confirmpassword").value;
console.log(password);

function checkPassword(){
if(password === confirm_password) {
/*   confirm_password.setCustomValidity("Passwords Don't Match");
 */
 } else {
/*   confirm_password.setCustomValidity('');
 */
	 alert("Passwords are not matching");

 }
}
/* 
password.onchange = checkPassword;
confirm_password.onkeyup = checkPassword; */
</script>

<style>
.login-form {
    width: 340px;
    margin: 50px auto;
  	font-size: 15px;
}
.login-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.login-form h2 {
    margin: 0 0 15px;
}
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
<div class="login-form">
    <form action="CreateCredentialServlet" method="post">
        <h2 class="text-center">Create credential</h2>       
        <div class="form-group">
            <input type="text" name="employeeid" class="form-control" placeholder="Employee Id" required="required" readonly>
        </div>
        
        <div class="form-group">
            <input type="text" name="username" class="form-control" placeholder="User Name" required="required">
        </div>
        
        <div class="form-group">
            <input type="password" id="newpassword" name="password" class="form-control" placeholder="New Password" required="required">
        </div>
        
        <!-- <div class="form-group">
            <input type="password" id="confirmpassword" name="confirmpassword" class="form-control" onBlur="checkPassword()" placeholder="Confirm Password" required="required">
        </div> -->
        
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block" >Create Credentials</button>
        </div>
               
    </form>
</div>
</body>
</html>