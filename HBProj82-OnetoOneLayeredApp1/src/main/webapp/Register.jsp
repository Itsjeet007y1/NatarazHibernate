<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: orange">Registration Page</h1>
	<hr>
	<form action="controller?param=link2" method="post">
		<h4 style="color: blue">Student Details</h4>
		Student Name: <input type="text" name="sname" /><br><br> 
		Address: <input type="text" name="sadd" /> <br><br>
		<input type="submit" value="Register"/><br>
	</form>
	${insertMsg}<br><br>
	<a href="index.jsp">Go To Home Page</a>
</body>
</html>