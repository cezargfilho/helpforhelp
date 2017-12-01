<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html >
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Help4Help</title>

</head>
<body>
<c:import url="topo.jsp"></c:import>
<c:import url="background.jsp"></c:import>

<table>
<tr>
<th> Nome </th>
<th> Telefone </th>
</tr>
<c:forEach var="e" items="${instituicaolist}">
<tr>
 <td> ${e.nome} </td>
 <td> ${e.telefone} </td>

<tr>
</c:forEach>
</table>
</body>
</html>