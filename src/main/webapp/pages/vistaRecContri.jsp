<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table, th, td {
                border: 1px solid black;
            }

            .right-container {
                float: right;
                width: 40%;
                padding: 20px;
            }

            .clear {
                clear: both;
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
                <th>Descripcion</th>
            </tr>

            <c:forEach items="${listaReclamos}" var="reclamo">
                <tr>
                    <td>${reclamo.fecha}</td>
                    <td>${reclamo.categoria}</td>
                    <td>${reclamo.domicilio}</td>
                    <td>${reclamo.descripcion}</td>

                </tr>
            </c:forEach>
        </table>
        
        
        <a href="/Finalprog2">Volver al Inicio</a>
        

        <!-- Container para el formulario alineado a la derecha -->
        <div class="right-container">
            <h2>Reportar Problema</h2>
            <form action="/Finalprog2/registroReclamo" method="post">
                <label for="domicilio">Domicilio:</label>
                <input type="text" name="domicilio" required><br>
                <label for="categoria">Categoría:</label>
                <select name="categoria">
                    <option value= 1 >Alumbrado</option>
                    <option value= 2 >Arbolado</option>
                    <option value= 3 >Limpieza</option>
                    <option value= 4 >Pluvial</option>
                </select><br>
                <label for="descripcion">Descripción:</label>
                <textarea name="descripcion" rows="4" cols="50" required></textarea><br>
                <input type="hidden" name="id" value=${id}>
                <input type="submit" value="Enviar Reporte">
            </form>
        </div>

        <!-- Limpiar el float para evitar que otros elementos floten alrededor -->
        <div class="clear"></div>
    </body>
</html>
