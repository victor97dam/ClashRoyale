<%-- 
    Document   : Comprar
    Created on : 05-may-2017, 18:20:52
    Author     : DAM
--%>
<%@page import="entities.Jugador"%>
<jsp:include page="/JugadorServlet" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="entities.Carta"%>
<jsp:useBean id="InfoUser" class="java.util.List" scope="request"/>
<jsp:useBean id="ListaCartas" class="java.util.List" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ComprarCartas" method="POST">
            
            <c:forEach items="${InfoUser}" var="item">
                <p> Oro Actual : ${item.oro} </p>
            </c:forEach>
            <table>
                <thead>
                <td>Nombre</td>
                <td>Vida</td>
                <td>Ataque</td>
                <td>Velocidad</td>
                <td>Elixir</td>
                <td>Categoría</td>
                </thead>
                <tbody>
                    <c:forEach items="${ListaCartas}" var="cartaslist">
                        <tr>
                            <td>${cartaslist.nombre}</td> 
                            <td>${cartaslist.vida}</td> 
                            <td>${cartaslist.ataque}</td> 
                            <td>${cartaslist.velocidad}</td> 
                            <td>${cartaslist.elixir}</td> 
                            <td>${cartaslist.categoria}</td>
                            <input hidden='${cartaslist.nombre}' name="NombreComprado">
                            <td><input type="submit" value="Comprar"></td>
                        </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
    </body>
</html>
