<%-- 
    Document   : CrearCartas
    Created on : 15-may-2017, 16:45:42
    Author     : DAM
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Message" class="java.lang.String" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${not empty Message}">
            <script>alert("a");</script>
        </c:if>
        <form action="CrearCartas" method="POST">
            <%=Message%>
            <span>Nombre</span><input name="nombre" type="text">
            <span>Vida</span><input name="vida" type="number">
            <span>Ataque</span><input name="ataque" type="number">
            <span>Velocidad</span><input name="velocidad" type="number">
            <span>Elixir</span><input name="elixir" type="number">
            <span>Categoría</span><input name="categoria" type="text">
            <input type="submit" value="Crear">
        </form>
    </body>
</html>
