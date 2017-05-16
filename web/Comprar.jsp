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

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<style>
    html{
        text-align: center
    }
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
    h1{
        text-align: center
    }
    img {
        width: 250px;
        height: 250px;
    }
    .col-lg-4{
        width: 30%;
        display: inline-block;
        text-align: center;
    }
</style>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clash Royale - Comprar Cofres</title>
    </head>
    <body>
        <c:if test="${not empty loginError}">
                    <script>alert("Error, revise el usuario y/o la contraseña")</script>
        </c:if>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand">Clash Royale</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active">
                        <form action="Batalla">
                            <input type="submit" value="Batalla" name="action">
                        </form>
                    </li>
                    <li>
                        <form action="Mejorar">
                            <input type="submit" value="Mejorar Cartas" name="action">
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
        <form action="ComprarCartas" method="POST">
            <c:forEach items="${InfoUser}" var="item">
                <h1>Oro Actual : ${item.oro} </h1>
                <div class="row">
                    <div class="col-md-4">
                        <c:if test="${item.oro >= 25}">
                            <img src="img/confre.png"><br/>
                            <input class="btn-success" width="100%" name="TipoCofre" type="submit" value="Cofre 1 Precio 100">
                        </c:if>
                    </div>
                    <div class="col-md-4">
                        <c:if test="${item.oro >= 50}">
                            <img src="img/cofre2.png"><br/>
                            <input class="btn-success" name="TipoCofre" type="submit" value="Cofre 2 Precio 50">
                        </c:if>
                    </div>
                    <div class="col-md-4">
                        <c:if test="${item.oro >= 100}">
                            <img  src="img/Cofre3.png" alt="Cofre 3" ><br/>
                            <input class="btn-success" name="TipoCofre" type="submit" value="Cofre 3 Precio 100 ">
                        </c:if>
                    </div>
                </div>
            </c:forEach>
        </form>
    </body>
</html>
