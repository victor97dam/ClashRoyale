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

            
            <div class="">
                <c:forEach items="${InfoUser}" var="item">
                    <h1>Oro Actual : ${item.oro} </h1>
                    <div>

                        <c:if test="${item.oro >= 25}">
                            <img src="img/confre.png">
                            <input name="TipoCofre" type="submit" value="Cofre1">
                        </c:if>
                    </div>
                    <div>
                        <c:if test="${item.oro >= 50}">
                            <img src="img/cofre2.png">
                            <input name="TipoCofre" type="submit" value="Cofre2">
                        </c:if>
                    </div>
                    <div>
                        <c:if test="${item.oro >= 100}">
                            <img  src="img/Cofre3.png" alt="Cofre 3" >
                            <input name="TipoCofre" type="submit" value="Cofre3">
                        </c:if>
                    </div>
                </c:forEach>
               
        </form>
    </div>
</body>
</html>
