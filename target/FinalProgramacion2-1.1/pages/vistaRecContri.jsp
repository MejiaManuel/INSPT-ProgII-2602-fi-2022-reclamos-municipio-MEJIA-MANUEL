<%-- 
    Document   : vistaReclamos
    Created on : 21 oct. 2022, 16:15:03
    Author     : Manu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vista Reclamos</title>
        <style>
         table, th, td {
            border: 1px solid black;
         }
      </style>
    </head>
    <body>

        <h1>Lista Reclamos de ${user}</h1>
      <table>
        <tr>
          <th>Fecha de creación</th>
    		<th>Categoría</th>
    			<th>Domicilio</th>
        </tr>

        <c:forEach items="${listaReclamos}" var="reclamo" >
          <tr>
           <th> ${reclamo.fecha} </th>
            <th>${reclamo.categoria}</th>
           <th> ${reclamo.domicilio}</th>
          </tr>
        </c:forEach>
        </table>
    </body>
</html>
