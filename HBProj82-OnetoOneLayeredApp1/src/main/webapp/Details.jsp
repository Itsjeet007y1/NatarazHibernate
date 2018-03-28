<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty stdList}">
		<table border="1">
			<tr>
				<caption>
					<h3>Available Details</h3>
				</caption>
				<th colspan="3" bgcolor="lightgreen">Student Details</th>
				<th colspan="2" bgcolor="lightblue">Library Details</th>
				<th bgcolor="orange">Operation</th>
			</tr>
			<tr>
				<th bgcolor="lightgreen">Sno</th>
				<th>Name</th>
				<th>Address</th>
				<th bgcolor="lightblue">LiD</th>
				<th>Library Joining Date</th>
			</tr>
			<c:forEach items="${stdList}" var="stdList">
				<tr>
					<td bgcolor="lightgreen">${stdList.sno}</td>
					<td>${stdList.sname}</td>
					<td>${stdList.sadd}</td>
					<td bgcolor="lightblue">${stdList.libraryDetails.lid}</td>
					<td>${stdList.libraryDetails.doj}</td>
					<td><a href="controller?param=link3&sno=${stdList.sno}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
	${msg}
	<br>
		<a href="Register.jsp">Click Here to Register another Student</a>
		</c:when>
		<c:otherwise>
			<h2 style="color:red">No any Record Found</h2>
			<a href="Register.jsp">Click Here to Register another Student</a>
		</c:otherwise>
	</c:choose>
</body>
</html>