<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,Modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas</title>
</head>
<body>
<c:import url="logout-parcial.jsp"/>

Usuario Logado : ${usuarioLogado.login}

<br>
<br>
<br>

	<c:if test="${not empty empresa}">
Empresa ${ empresa } cadastrada com sucesso!
</c:if>



	Lista de Empresas :
	<br />


	<ul>
		<c:forEach items="${empresas}" var="empresa">

			<li>${empresa.nome}- <fmt:formatDate
					value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />
					<a href="/FirstServlet/Entrada?acao=MostraEmpresas&id=${empresa.id}">edita</a>
					<a href="/FirstServlet/Entrada?acao=RemovaEmpresas&id=${empresa.id}">remove</a>
			</li>
		</c:forEach>
	</ul>
		<a href="FirstServlet/Entrada?acao=NovaEmpresasForm">Adicionar Empresa</a>



	


</body>
</html>