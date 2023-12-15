<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
   
    
    <h3>Inicio Sesion</h3>
        <form name="form1" action="/Finalprog2/Parcial2" method="post" >
            <label for="user">Usuario:</label> <br>
            <input type="text" id="user" name="user">
            <br/><br/>
            <label for="pass">Clave: </label> <br>
            <input type="password" id="pass" name="pass">
            <br/><br/>
            <input type="submit">
            <input type="reset">
        </form>
    <a href="./pages/CrearUsuario.jsp">O crear usuario</a>
    
</body>
</html>
