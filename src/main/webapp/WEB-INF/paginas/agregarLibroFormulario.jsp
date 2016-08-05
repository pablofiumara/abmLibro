<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Página para agregar libro</title>
</head>
<body>
<h1>Agregue un nuevo libro</h1>
<p>Puede agregar un nuevo libro a la base de datos completando el formulario que se encuentra debajo:</p>

<form:form method="POST" commandName="libroNuevo" action="${pageContext.request.contextPath}/">
<table>
<tbody>
	<tr>
		<td>Titulo del libro:</td>
		<td><form:input path="titulo" /></td>
	</tr>
	<tr>
		<td><input type="submit" value="Agregar" /></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>


</body>
</html>