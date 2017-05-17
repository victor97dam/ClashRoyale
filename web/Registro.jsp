<%-- 
    Document   : Registro
    Created on : 25-abr-2017, 17:45:18
    Author     : DAM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="logincss.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<jsp:useBean id="RegistroFail" class="java.lang.String" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="backgroundstyle"></div>
        <div class="container">
            <div class="card card-container">
        <h1>Crear Jugador</h1>
        <c:if test="${not empty RegistroFail}">
                    <script>alert("Error,este usuario ya existe")</script>
        </c:if>
        <form  action="JugadorServlet" method="POST">
            <span>Nombre:</span><input type="text" name="usuario" required><br/>
            <span>Password:</span><input type="password" name="password" required><br/>
            <input type="submit" value="Crear" name="action" ><br/>
            <input hidden="createusu" ><br/>
        </form>
            </div>
        </div>
    </body>
</html>
