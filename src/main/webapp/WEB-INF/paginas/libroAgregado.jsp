<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Informacion sobre el libro agregado</title>
</head>
<body>

	<h2>Libro agregado</h2>
	<table>
		<tr>
			<td>Titulo :</td>
			<td>${titulo}</td>
		</tr>
	</table>
	<br>

	<p><a href="${pageContext.request.contextPath}/libros/mostrar.html">Lista de libros</a></p>
	<br>
	<p><a href="${pageContext.request.contextPath}/libros/agregar">Agregar un libro</a></p>
	<%-- <a href="/abmLibro/libros/agregar">Agregar libro</a>  --%>
</body>
</html>