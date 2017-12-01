<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Help4Help</title>
</head>
<c:import url="WEB-INF/css/input.css"></c:import>
<body>
<div id = "div_input">
<form action="instituicoes" method="post">
Login:<input type= "text" name="login"/><br>
Senha:<input type= "password" name="senha"/><br>
Email:<input type= "text" name="email"/>
<input type="submit" value="Cadastrar">
</form></div>
</body>
</html>