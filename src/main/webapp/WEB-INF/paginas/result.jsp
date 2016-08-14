<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
	<h1>Forecast for ${forecastReturn.getCity()}, ${forecastReturn.getState()}</h1>
	<table border="1">
		<tr>
			<th>Date</th>
			<th>Desciption</th>
			<th>LowTemp(&#176;C)</th>
			<th>HighTemp(&#176;C)</th>
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