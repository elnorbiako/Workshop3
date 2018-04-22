<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 22.04.18
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h2><strong>User list</strong></h2>
<table width="100%">
    <tr><th>ID</th><th>Name</th><th>email</th><th>Group Id</th></tr>
    <c:forEach var="user" items="${users}">

    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.userGroupId}</td>
        <td><a href="/useredit?id=${user.id}"> Edit user</a></td>

    </tr>
    </c:forEach>
</table>


</body>
</html>
