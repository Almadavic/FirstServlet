<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/Entrada" var="linkEntrada"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insira o nome</title>
</head>
<body>

<c:import url="logout-parcial.jsp"/>

<form action="${linkEntrada}" method="post">

    Nome : <input type="text" name="nome"/>
    Data Abertura : <input type="text" name= "data"/>
    <input type="hidden" name="acao" value = "NovaEmpresas">
    <input type="submit"/>

</form>
</body>
</html>