<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login</title>

<style type="text/css">
body {
	text-align: left;
	margin: 0;
	padding: 0;
}
.error {
	background-color: #FFF;
	color: red;
	text-align: left;
}
</style>

</head>
<body>
<h1>Login</h1>
<p>Ingrese su nombre de usuario y contraseña para agregar un libro</p>
<form:form method="POST" modelAttribute="unLibro" action="${pageContext.request.contextPath}/agregarLibro.html">
<table>
<tbody>
	<tr>
		<td>Nombre de usuario:</td>
		<td><form:input path="usuario" /></td>
		<td><form:errors path="titulo" cssClass="error" /></td>

	</tr>
		<tr>
		<td>Contraseña:</td>
		<td><form:input path="contraseña" /></td>
		<td><form:errors path="contraseña" cssClass="error" /></td>

	</tr>
	<tr>
		<td><input type="submit" value="Ingresar" /></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>


</body>
</html>