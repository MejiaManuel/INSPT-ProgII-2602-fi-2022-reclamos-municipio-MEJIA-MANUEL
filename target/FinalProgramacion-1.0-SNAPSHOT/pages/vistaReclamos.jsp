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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista Reclamos</h1>
        
        <c:forEach items="${listaReclamos}" var="reclamo" >
            ${reclamo.id}
            ${reclamo.descripcion}<br>

        </c:forEach>
    </body>
</html>
