<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

    <html lang="en">

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">

            <title>Top news &amp; authors </title>

            <link href="css/bootstrap.min.css" rel="stylesheet">

            <link href="css/offcanvas.css" rel="stylesheet">

            <style>
                th.normal {
                    font-weight: normal;
                }
            </style>

        </head>

        <body>

            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="container">



                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="Servlet?method=read_news">Main </a>
                            </li>
                            <li><a href="Servlet?method=read_stats">Statistics</a>
                            </li>
                            <li class="active"><a href="Servlet?method=read_top_news">Top News <span class="sr-only">(current)</span></a>
                            </li>
                            <li><a href="indexAjax.jsp">AJAX</a>

                        </ul>


                    </div>
            </nav>

            <div class="container">

                <div class="col-md-6">

                    <h2 class="text-center"> Top monthly news </h2>

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Circulation</th>

                            </tr>
                        </thead>
                        <tbody>

                            <c:choose>
                                <c:when test="${not empty topnews}">
                                    <c:forEach items="${topnews}" var="item">

                                        <tr>
                                            <th class="normal"> ${item.name}</th>
                                            <th class="normal"> ${item.circulation}</th>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                <h3>News are not exist</h3>
                            </c:otherwise>
                        </c:choose>

                        </tbody>
                    </table>


                </div>



                <div class="col-md-6">
                    <h2 class="text-center"> Top 5 authors </h2>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Author</th>
                                <th>Total circulation</th>

                            </tr>
                        </thead>
                        <tbody>

                            <c:choose>
                                <c:when test="${not empty topauth}">
                                    <c:forEach items="${topauth}" var="item">

                                        <tr>
                                            <th class="normal"> ${item.authorName}</th>
                                            <th class="normal"> ${item.circulation}</th>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                <h3>News are not exist</h3>
                            </c:otherwise>
                        </c:choose>

                        </tbody>
                    </table>

                </div>
            </div>
            <hr>

            <script src="js/bootstrap.min.js"></script>
            <script src="js/offcanvas.js"></script>
        </body>

    </html>