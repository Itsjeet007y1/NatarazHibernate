<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:orange">Money Transfer Page</h1>
	<form action="controller?param=link3" method="post">
		Source AccNo: <input type="text" name="sano"/><br><br>
		Destination AccNo: <input type="text" name="dano"/><br><br>
		Amount:	<input type="text" name="balance"/> Rs.<br><br>
		<input type="submit"  value="Transfer"/>
	</form><br>
	${msg}<br><br>
	<a href="index.jsp">Accounts Page</a>
</body>
</html>