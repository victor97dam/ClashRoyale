<%-- 
    Document   : Main
    Created on : 28-abr-2017, 19:40:08
    Author     : DAM
--%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<style>
    #myCarousel img{
        height: 95%;
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
</style>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clash Royale - Menú </title>
    </head>
    <body>
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
                        <form action="ComprarCartas">
                            <input type="submit" value="Comprar Cartas">
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
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">

                <div class="item active">
                    <img src="img/RoyaleMain1.jpg" style="width:100%;">
                </div>

                <div class="item">
                    <img src="img/RoyaleMain2.jpg"  style="width:100%;">
                </div>

                <div class="item">
                    <img src="img/RoyaleMain3.jpg" style="width:100%;">
                </div>

            </div>
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </body>
</html>
