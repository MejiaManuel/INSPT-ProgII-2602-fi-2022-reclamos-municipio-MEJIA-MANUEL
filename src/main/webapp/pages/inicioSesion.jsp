<%-- 
    Document   : inicioSecion
    Created on : 28 oct. 2022, 14:52:56
    Author     : Manu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio Sesion</title>
    </head>
    <body>
        <h1>Inicio Sesion</h1>
        <form name="form1" action="/reclamos/all" method="post" >
            <label for="user">Usuario:</label> <br>
            <input type="text" id="user" name="user">
            <br/><br/>
            <label for="pass">Clave: </label> <br>
            <input type="password" id="pass" name="pass">
            <br/><br/>
            <input type="submit">
            <input type="reset">
        </form>
    </body>
</html>
