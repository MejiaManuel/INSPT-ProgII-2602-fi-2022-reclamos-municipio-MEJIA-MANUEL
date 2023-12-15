<%-- 
    Document   : CrearUsuario
    Created on : 14 dic. 2023, 21:10:57
    Author     : Manu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <body>
        <h2>Crear Usuario</h2>
        <form action="/Finalprog2/registroUsuario" method="post">
            <label for="usuario">Usuario:</label>
            <input type="text" name="usuario" required><br>

            <label for="clave">Clave:</label>
            <input type="password" name="clave" required><br>

            <label for="dni">DNI:</label>
            <input type="text" name="dni" required><br>

            <label for="mail">Correo Electrónico:</label>
            <input type="email" name="mail" required><br>

            <label for="telefono">Teléfono:</label>
            <input type="text" name="telefono" required><br>

            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" required><br>

            <label for="apellido">Apellido:</label>
            <input type="text" name="apellido" required><br>

            <input type="submit" value="Crear Usuario">
        </form>
    </body>
</html>
