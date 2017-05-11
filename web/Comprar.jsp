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

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <style>
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
        <form action="ComprarCartas" method="POST">
            <c:forEach items="${InfoUser}" var="item">
                <h1>Oro Actual : ${item.oro} </h1>
                <div class="row">
                    <div class="col-lg-4">
                        <c:if test="${item.oro >= 25}">
                            <img src="img/confre.png"><br/>
                            <input class="btn-success" width="100%" name="TipoCofre" type="submit" value="Cofre1">
                        </c:if>
                    </div>
                    <div class="col-lg-4">
                        <c:if test="${item.oro >= 50}">
                            <img src="img/cofre2.png"><br/>
                            <input class="btn-success" name="TipoCofre" type="submit" value="Cofre2">
                        </c:if>
                    </div>
                    <div class="col-lg-4">
                        <c:if test="${item.oro >= 100}">
                            <img  src="img/Cofre3.png" alt="Cofre 3" ><br/>
                            <input class="btn-success" name="TipoCofre" type="submit" value="Cofre3">
                        </c:if>
                    </div>
                </div>
            </c:forEach>
        </form>
    </body>
</html>
