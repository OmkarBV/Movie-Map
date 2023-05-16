<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Admin Login</title>



<style>
body {
	font-family: Arial, sans-serif;
	background-color: whitesmoke;
	font-size: 40px;
}

.form-div {
	margin: 100px;
	color: aliceblue;
	text-align: center;
	border-radius: 10PX;
	padding-bottom: 20px;
	padding-top: 15px;
	background: url("/img/loginbackground.jpg") center fixed no-repeat;
	box-shadow: 0 0 30px rgb(0, 0, 0);
}

.form-div input {
	border: solid;
	font-size: 30px;
	border-radius: 50px;
	text-align: center;
	transition: 0.5s;
	background-color: rgb(255, 255, 255);
}

.form-div input:hover {
	font-family: 'Courier New', Courier, monospace, rgb(255, 65, 65);
	scale: 0.9 1.1;
	color: rgb(255, 91, 91);
}

</style>
<c :url value="/img/loginbackground.jpg" var="loginbackground" />
</head>

<body>

	<!-- Login Form -->
	<div class="form-div">
		<h2>Admin Login</h2>
		<h4 style="color: red">
			<%
			if (request.getAttribute("sms") != null) {
				out.print(request.getAttribute("sms"));
			}
			%>
		</h4>
		<form action="adminlogin">
			<input type="text" placeholder="Admin Number" required name="number">
			<br></BR> <input type="text" placeholder="Password" name="password"
				required> <br></BR> <input type="submit" value="Login">
		</form>

		<!-- <form action="gotoadminregister">
			<input type="submit" value="New Admin">
		</form>
		 -->
		<form action="gotouserlogin">
			<input type="submit" value="User Login">
		</form>
	</div>


</body>
</html>