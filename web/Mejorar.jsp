<%-- 
    Document   : Mejorar
    Created on : 05-may-2017, 20:10:15
    Author     : DAM
--%>
<%@page import="java.util.List"%>
<%@page import="entities.Baraja"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="CartasPropias" class="java.util.List" scope="request" />

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
            <td>Cantidad</td>
            <td>Nivel</td>
        </thead>
        <tbody>
            <%
                List<Baraja> barajas = (List<Baraja>) request.getAttribute("CartasPropias");
                for (Baraja baraja : barajas) {
            %>
            <tr>
                <td><%= baraja.getBarajaPK().getCarta()%></td> 
                <td><%= baraja.getCantidad()%></td>
                <td><%= baraja.getNivel()%></td>
                <td><input type="submit" value="Comprar"></td>
            </tr>
            <% }
            %>
        </tbody>
    </table>
</body>
</html>
