<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edite un libro</title>
</head>


<body>
<h1>Modifique los datos de un libro</h1>
<p>Complete el formulario de acuerdo a las modificaciones que desee realizar</p>

<form:form method="POST" commandName="libro" action="${pageContext.request.contextPath}/modificar/${libro.id}">
<table>
<tbody>

	<tr>
		<td>Id:</td>
		<td><form:input path="id" /></td>
	</tr>

	<tr>
		<td>Título del libro:</td>
		<td><form:input path="titulo" /></td>
	</tr>

	<tr>
		<td><input type="submit" value="Modificar" /></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>


</body>
</html>