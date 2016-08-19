<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Lista de libros</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">Volver a la página inicial</a><br/><br/>
<a href="${pageContext.request.contextPath}/lista-libros.pdf">Generar PDF</a><br/><br/>

<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="10%">Id</th><th width="15%">Título</th><th width="10%">Opciones</th>
</tr>
</thead>
<tbody>
<c:forEach var="unLibro" items="${listaLibros}">
<tr>
	<td>${unLibro.id}</td>
	<td>${unLibro.titulo}</td> <!--  unLibro.titulo refiere al atributo del modelo Libro -->
	<td>
	<a href="${pageContext.request.contextPath}/borrar/${unLibro.id}.html">Borrar libro</a><br/>
	<a href="${pageContext.request.contextPath}/modificar/${unLibro.id}.html">Modificar</a><br/>


	</td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>