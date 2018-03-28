<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@page isELIgnored="false" %>

<h1 style="color:red;text-align:center">Change Project </h1>
<form action="controller" method="post">
 Select New ProjectIds:: 
        <select name="new_projectId" >
         <c:if test="${listDTO ne null }">
            <c:forEach var="dto" items="${listDTO }">
              <option value="${dto.proid}">${dto.proid} ---${dto.proname}</option>
              </c:forEach>
           </c:if>
            </select> <br>
       <input type="hidden" name="h_prgmrId" value="${prgmrId}"/>
       <input type="hidden" name="h_oldprojId" value="${projId}"/>
<input type="submit"  name="param" value="changeProject"/>
</form>