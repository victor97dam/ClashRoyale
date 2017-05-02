<%-- 
    Document   : Login
    Created on : 28-abr-2017, 19:33:24
    Author     : DAM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="JugadorServlet" method="POST">
            <span>Nombre:</span><input type="text" name="usuario" required>
            <span>Password:</span><input type="password" name="password" required>
            <input type="submit" value="Login" name="action" >
        </form>
    </body>
</html>
