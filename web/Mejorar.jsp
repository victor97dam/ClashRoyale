<%-- 
    Document   : Mejorar
    Created on : 05-may-2017, 20:10:15
    Author     : DAM
--%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@page import="java.util.List"%>
<%@page import="entities.Baraja"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="CartasPropias" class="java.util.List" scope="request" />
<style>
    .navbar{
        margin-bottom: 0px !important
    }
    input{
        color: white;
        padding: 13px;
        width: 100%;
        font-size: 15px;
        font-family: "Times New Roman", Georgia, Serif;
        border: none;
        background: none;
    }

</style>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clash Royale - Mejorar Cartas</title>
    </head>
    <body>
        <div class="backgroundstyle"></div>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="Main.jsp" >Clash Royale</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active">
                        <form action="Batalla">
                            <input type="submit" value="Batalla" name="action">
                        </form>
                    </li>
                    <li>
                        <form action="ComprarCartas">
                            <input type="submit" value="Comprar Cartas">
                        </form>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <form action="CerrarSesion">
                        <button type="submit">
                            <span class="glyphicon glyphicon-log-in"></span>
                        </button>
                    </form>
                </ul>
            </div>
        </nav>
        <div class="container">
            <h2>Cartas Adquiridas</h2>
            <p>Aquí se mostrarán las cartas que tienes, en caso que puedas mejorarlas que puedas mejorarlas se te mostrará un botton (el coste de mejora es de 25)</p>            
            <form action="Mejorar" method="POST">


                <table class="table table-striped table-bordered">
                    <thead  class="thead-inverse">
                        <tr>
                            <th style="width: 35%">Nombre</th>
                            <th style="width: 35%">Cantidad</th>
                            <th style="width: 35%">Nivel</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="baraja" items="${CartasPropias}">
                            <tr>
                                <td>${baraja.barajaPK.carta}</td>
                                <td>${baraja.cantidad}</td>
                                <td>${baraja.nivel}</td>
                                <c:if test="${baraja.cantidad > 9}">
                            <input type="hidden" name="cartaamejorar" value="${baraja.barajaPK.carta}"> 
                            <td><input type="submit" value="Comprar"></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </form>
        </div>
    </body>
</html>
