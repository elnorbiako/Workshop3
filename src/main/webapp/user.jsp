<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 22.04.18
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h2><strong>User details</strong></h2>
<table width="100%">
    <tr><th>ID</th><th>Name</th><th>email</th><th>Password (encrypted)</th></tr>

    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.password}</td>

    </tr>
</table>

    <h2><strong>User solutions</strong></h2>

<table width="100%">
    <tr><th>ID</th><th>Created</th><th>Updated</th><th>Description</th><th>Excercise Id</th></tr>
    <c:forEach var="solution" items="${solutions}">
        <tr>
            <td>${solution.id}</td>
            <td>${solution.created}</td>
            <td>${solution.updated}</td>
            <td>${solution.description}</td>
            <td>${solution.excerciseId}</td>
        </tr>
    </c:forEach>
</table>

</body>

</html>
