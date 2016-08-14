<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
	<a href="${pageContext.request.contextPath}/">Volver a la p�gina inicial</a><br/><br/>
	<h1>Pron�stico para ${unaRespuestaPronostico.getCity()}, ${unaRespuestaPronostico.getState()}</h1>
	<table border="1">
		<tr>
			<th>Fecha</th>
			<th>Descripci�n</th>
			<th>TemperaturaM�nima(&#176;F)</th>
			<th>TemperaturaM�xima(&#176;F)</th>
		</tr>
		<c:forEach items="${pronosticosLista}" var="forecast">
			<tr>
				<td><fmt:formatDate pattern="dd-MM-yyyy" value="${forecast.getDate().toGregorianCalendar().getTime()}"/></td>
				<td>${forecast.getDesciption()}</td>
				<td>${forecast.getTemperatures().getMorningLow()}</td>
				<td>${forecast.getTemperatures().getDaytimeHigh()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>