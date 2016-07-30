<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
 <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>Lista de libros</title>
 </head>
 <body>
     <div align="center">
         <h1>Lista de libros</h1>
         <table border="1">
             <th>No</th>
             <th>Titulo del libro</th>


             <c:forEach var="listaDeLibros" items="${listaDeLibros}">
             <tr>

                 <td>${listaDeLibros.id}</td>
                 <td>${listaDeLibros.titulo}</td>

             </tr>
             </c:forEach>
         </table>
     </div>
 </body>
</html>