<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Help4Help</title>

</head>
<c:import url="topo.jsp"></c:import>
<c:import url="background.jsp"></c:import>
<body>
<div class="w3-display-middle container">
<form action = "">
<p class = "w3-text-black">Nome:</p>
<input type = "text" class = "w3-border-grey nome">
<p class = "w3-text-black">Comentario:</p>
<textarea class = "w3-border-grey comentario" name = "comentario"></textarea>
<br>
<br>
<input id = "" type="submit" value="Enviar">	
</form>
</div>
</body>

<c:import url="rodape.jsp"></c:import>
<c:import url="WEB-INF/css/footer.css"></c:import>
</html>