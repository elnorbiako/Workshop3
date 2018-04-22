<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 22.04.18
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2><strong>List of all excercises</strong></h2>
<table width="100%">
    <tr><th>ID</th><th>Title</th><th>Description</th></tr>

    <c:forEach var="exce" items="${exces}">
        <tr>
            <td>${exce.id}</td>
            <td>${exce.title}</td>
            <td>${exce.description}</td>

        </tr>
    </c:forEach>
</table>

</body>
</html>