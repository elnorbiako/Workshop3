<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 22.04.18
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--header--%>
<%@ include file="header.jsp" %>


<h2><strong>Last 5 added solutions</strong></h2>
<table width="100%">
    <%--<tr><th>ID</th><th>Created</th><th>Updated</th><th>Description</th><th>User Id</th><th>Excercise Id</th></tr>--%>
<tr><th>User Id</th><th>Excercise Id</th><th>Link</th></tr>
    <c:forEach var="solution" items="${sols}">
    <tr>
        <%--<td>${solution.id}</td>--%>
        <%--<td>${solution.created}</td>--%>
        <%--<td>${solution.updated}</td>--%>
        <%--<td>${solution.description}</td>--%>
        <td>${solution.usersId}</td>
        <td>${solution.excerciseId}</td>
        <td><a href="/solDetails?id=${solution.id}"> Details </a></td>

    </tr>
    </c:forEach>
</table>


</body>
<%--footer--%>
<%@ include file="footer.jsp" %>
</html>
