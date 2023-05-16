<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Register</title>

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
	background: url("img/image4.jpeg") center fixed no-repeat;
	background-color: rgba(0, 0, 0, 0.61);
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


</head>

<body>

	<div class="form-div">
		<h2>User Register</h2>
		<h4 style="color: red">
			<%
			if (request.getAttribute("sms") != null) {
				out.print(request.getAttribute("sms"));
			}
			%>
		</h4>
		<form action="userregister">
			Number<input type="text" name="number" required><br> <br>
			Name <input type="text" name="name" required><br> <br>
			Email <input type="email" name="email" required> <br> <br>
			Password <input type="text" name="password" required> <br>
			<br> <input type="submit" value="REGISTER">
		</form>

	</div>

</body>


</html>