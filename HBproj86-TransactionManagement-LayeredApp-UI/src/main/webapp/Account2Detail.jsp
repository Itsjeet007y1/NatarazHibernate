<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:green">Account2 Details</h1>
	<form action="Transfer.jsp">
		<span style="color:red">Account Number: ${acc.acno}</span><br><br>
		<span style="color:red">Holder Name:	${acc.holder}</span><br><br>
		<span style="color:red">Available Balance: ${acc.balance}</span><br><br>
		<input type="submit" value="Transfer Money"/>
	</form>
</body>
</html>