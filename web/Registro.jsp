<%-- 
    Document   : Registro
    Created on : 25-abr-2017, 17:45:18
    Author     : DAM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="RegistroFail" class="java.lang.String" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crear Jugador</h1>
        <c:if test="${not empty RegistroFail}">
                    <script>alert("Error,este usuario ya existe")</script>
        </c:if>
        <form action="JugadorServlet" method="POST">
            <span>Nombre:</span><input type="text" name="usuario" required>
            <span>Password:</span><input type="password" name="password" required>
            <input type="submit" value="Crear" name="action" >
            <input hidden="createusu" >
        </form>
    </body>
</html>
