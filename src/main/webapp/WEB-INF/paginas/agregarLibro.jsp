<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <form:form method="POST" action="/abmLibro/libroAgregado" modelAttribute="libro">
             <table>
                <tr>
                    <td><form:label path="titulo">Titulo</form:label></td>
                    <td><form:input path="titulo"/></td>
                </tr>
                <tr>
                    <td><form:label path="Id">Id</form:label></td>
                    <td><form:input path="Id"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>