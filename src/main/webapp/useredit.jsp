<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 22.04.18
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>User edition menu</h2>
<form method ='post' action = '/useredit'>
    New name for user ${id}: <input type ='text' name ='name'/><br>
    New email: <input type ='text' name ='email'/><br>
    New password: <input type ='text' name ='password'/><br>
    New Group Id <input type ='number' name ='groupId'/><br>

    <input type="hidden" name="id" value=${id}>
    <input type ='submit' />
</form>

</body>
</html>
