<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.victor.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas</title>
</head>
<body>

	<c:if test="${not empty empresa}">
Empresa ${ empresa } cadastrada com sucesso!
</c:if>



	Lista de Empresas :
	<br />


	<ul>
		<c:forEach items="${empresas}" var="empresa">

			<li>${empresa.nome}- <fmt:formatDate
					value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />
					<a href="/FirstServlet/mostraEmpresa?id=${empresa.id}">edita</a>
					<a href="/FirstServlet/removeEmpresa?id=${empresa.id}">remove</a>
			</li>
		</c:forEach>
	</ul>


</body>
</html>