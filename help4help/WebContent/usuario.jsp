<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de usuários</title>
</head>
<body>
<table>
<tr>
<th>Login</th>
<th>Senha</th>
<th>Email</th>
</tr>
<c:forEach var="cj" items="${lista} }">
<tr>
<td>${cj.login}</td>
<td>${cj.senha}</td>
<td>${cj.email}</td>
</tr>
</c:forEach>
</table>>

</body>
</html>