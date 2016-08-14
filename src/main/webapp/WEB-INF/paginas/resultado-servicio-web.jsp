<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
	<h1>Pronóstico para ${unaRespuestaPronostico.getCity()}, ${unaRespuestaPronostico.getState()}</h1>
	<table border="1">
		<tr>
			<th>Fecha</th>
			<th>Descripción</th>
			<th>TemperaturaMínima(&#176;C)</th>
			<th>TemperaturaMáxima(&#176;C)</th>
		</tr>
		<c:forEach items="${forecasts}" var="forecast">
			<tr>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${forecast.getDate().toGregorianCalendar().getTime()}"/></td>
				<td>${forecast.getDesciption()}</td>
				<td>${forecast.getTemperatures().getMorningLow()}</td>
				<td>${forecast.getTemperatures().getDaytimeHigh()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>