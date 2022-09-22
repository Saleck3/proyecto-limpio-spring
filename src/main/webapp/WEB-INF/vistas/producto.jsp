<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar Producto</title>
</head>
<body>
	<h1>Producto nuevo!</h1>
	<form:form action="registrar" method="POST" modelAttribute="producto">
		Nombre : <form:input path="nombre" type="text" />
		<br>
		Código : <form:input path="codigo" type="text" />
		<br>
		<button type="Submit">Agregar producto</button>

	</form:form>
</body>
</html>