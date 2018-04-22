<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 22.04.18
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2><strong>List of all groups</strong></h2>
<table width="100%">
    <tr><th>Group Id</th><th>Name</th><th>Members</th></tr>
    <c:forEach var="group" items="${groups}">
        <tr>

            <td>${group.id}</td>
            <td>${group.name}</td>
            <td><a href="/members?id=${group.id}"> Members... </a></td>
            <td><a href="/groupedit?id=${group.id}"> Edit group</a></td>

        </tr>
    </c:forEach>
</table>

<h2>Add a new group: </h2>
<form method ='post' action = '/addgroup'>
    Id for new group: <input type ='number' name ='id'/><br>
    Name for new group: <input type ='text' name ='name'/><br>
    <input type ='submit' />
</form>

</body>
</html>
