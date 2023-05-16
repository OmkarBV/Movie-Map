<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
</head>
<body>
	<%
	if (request.getAttribute("sms") != null) {
		out.print(request.getAttribute("sms"));
	}
	%>

	<form action="forgotpass">
		<h2>Enter Email</h2>
		<input type="text" name="email" placeholder="Enter Email"> <input
			type="submit" value="Send OTP">
	</form>

	<form action="enterotp">
		<h2>Confirm OTP</h2>
		<input type="text" name="otp" placeholder="Enter OTP"> <input
			type="text" name="password" placeholder="New Password"> <input
			type="text" name="confirmpassword" placeholder="Confirm Password">
		<input type="submit" value="Confirm OTP">
	</form>
	<%
	if (request.getAttribute("smsotp") != null) {
		out.print(request.getAttribute("smsotp"));
	}
	%>
</body>
</html>