<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
<h1 style='color:red'> Employee Report </h1>

<c:choose>
  <c:when test="${reportData ne null}">
       <table border="1">
         <tr><th>Emp no</th><th>First name</th><th>Lastname</th><th>Email</th></tr>
         <c:forEach  var="emp" items="${reportData}">
           <tr>
             <td>${emp.eid}</td>
             <td>${emp.firstName}</td>
             <td>${emp.lastName}</td>
             <td>${emp.email}</td>
           </tr>             
         </c:forEach>         
       </table>
       <br><br>
  </c:when>
  <c:otherwise>
      <b><i>Records not Found</i></b>
  </c:otherwise>
</c:choose>

  <c:if test="${linksCount ne null}">
      <c:forEach var="i"  begin="1" end="${linksCount}" step="1">
         <a href="controller?pageNo=${i}">[${i}]</a> &nbsp;&nbsp;&nbsp;
      </c:forEach>
  </c:if>


