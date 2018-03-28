<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@page isELIgnored="false" %>
  <br><br>
     <b><p style="color:red">${prgmrId} &nbsp; &nbsp; ${prgmrMsg}</p></b> <br>

<c:choose>
	<c:when test="${listDTO ne null }">
		<c:forEach var="projectDTO" items="${listDTO}">
			<h1 style="color: blue">${projectDTO.proid}
				&nbsp;&nbsp;&nbsp;${projectDTO.proname}</h1>
			<c:forEach var="programmerDTO" items="${projectDTO.programmers }">
				<h4 style="color: red">${programmerDTO.pid}
					&nbsp;&nbsp;&nbsp;${programmerDTO.pname}&nbsp;&nbsp;&nbsp;${programmerDTO.salary}
					&nbsp;&nbsp;<a href="controller?param=link1&prgmrid=${programmerDTO.pid }&projid=${projectDTO.proid}">delete</a>
					&nbsp;&nbsp;<a href="controller?param=link2&prgmrid=${programmerDTO.pid }&projid=${projectDTO.proid}">moveTo another Project</a>
				</h4>
			</c:forEach>
		</c:forEach>
		</c:when>
		<c:otherwise>
		    <h1>Data not found</h1>
		</c:otherwise>
</c:choose>
 