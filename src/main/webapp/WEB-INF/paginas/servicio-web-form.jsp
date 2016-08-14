<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<html>
<body>
	<form  action="resultado-servicio-web" method="POST">
		Escriba código postal (sólo EE.UU; por ejemplo, 10001 para Nueva York):<br> 
		<input type="text" name="codigoPostal"><br>
		<input type="submit" value="Enviar">
	</form>
</body>
</html>