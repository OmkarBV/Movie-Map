<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="adminregister">
		Number<input type="text" name="number" required> Name <input
			type="text" name="name" required> Email <input type="email"
			name="email" required> Password <input type="text"
			name="password" required> <input type="submit"
			value="REGISTER">
	</form>

	<%
	if (request.getAttribute("sms") != null) {
		out.print(request.getAttribute("sms"));
	}
	%>
</body>
</html>