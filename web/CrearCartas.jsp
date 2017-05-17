<%-- 
    Document   : CrearCartas
    Created on : 15-may-2017, 16:45:42
    Author     : DAM
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="logincss.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<jsp:useBean id="Message" class="java.lang.String" scope="request"/>
<style>
    .navbar{
        margin-bottom: 0px !important
    }
    ul > li > input{
        color: white;
        padding: 13px;
        width: 100%;
        font-size: 15px;
        font-family: "Times New Roman", Georgia, Serif;
        border: none;
        background: none;
    }
    
    .comprar{
        color: #33ff33 !important
    }

</style>
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
            <div class="card card-container">
        <form action="CrearCartas" method="POST">
            <%=Message%>
            <span>Nombre</span><input name="nombre" type="text"><br/>
            <span>Vida</span><input name="vida" type="number"><br/>
            <span>Ataque</span><input name="ataque" type="number"><br/>
            <span>Velocidad</span><input name="velocidad" type="number"><br/>
            <span>Elixir</span><input name="elixir" type="number"><br/>
            <span>Categoría</span><input name="categoria" type="text"><br/>
            <input type="submit" value="Crear">
        </form>
            </div>
        </div>
    </body>
</html>
