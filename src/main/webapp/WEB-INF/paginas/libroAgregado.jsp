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
	<a href="/abmLibro/libros/mostrar">Lista de libros</a>
	<br>
	<a href="/abmLibro/libros/agregar">Agregar libro</a>
</body>
</html>