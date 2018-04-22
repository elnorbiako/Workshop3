<%--
  Created by IntelliJ IDEA.
  User: norbiak
  Date: 22.04.18
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Group edition menu</h2>
<form method ='post' action = '/groupedit'>
    New name for group ${id}: <input type ='text' name ='name'/><br>
    <input type="hidden" name="id" value=${id}>
    <input type ='submit' />
</form>

</body>
</html>
