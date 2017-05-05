<%-- 
    Document   : Comprar
    Created on : 05-may-2017, 18:20:52
    Author     : DAM
--%>
<jsp:include page="/JugadorServlet" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="entities.Carta"%>
<jsp:useBean id="ListaCartas" class="java.util.List" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
            <%
                List<Carta> cartas = (List<Carta>) request.getAttribute("ListaCartas");
                for (Carta carta : cartas) {
            %>
            <tr>
                <td><%= carta.getNombre()%></td> 
                <td><%= carta.getVida()%></td> 
                <td><%= carta.getAtaque()%></td> 
                <td><%= carta.getVelocidad()%></td> 
                <td><%= carta.getElixir()%></td> 
                <td><%= carta.getCategoria()%></td>
                <td><input type="submit" value="Comprar"></td>
            </tr>
            <% }
            %>
        </tbody>
    </table>
</body>
</html>
