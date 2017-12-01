<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body background="http://livrit.com.br/img/background-triangulos-livrit.jpg">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="WEB-INF/css/header.css"></c:import>
<c:import url="topo.jsp"></c:import>
 <div class="w3-display-middle w3-container">
  <div class="w3-container w3-orange">
    <p class="w3-center w3-text-white">Seja um doador no Help4Help</p>
  </div>
 <jsp:include page = "formUsuario.jsp" />
 </div>