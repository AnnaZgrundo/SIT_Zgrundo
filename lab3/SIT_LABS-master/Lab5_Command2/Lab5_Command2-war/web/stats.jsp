<%-- 
    Document   : stats
    Created on : May 8, 2015, 8:27:14 PM
    Author     : Ivan Bachilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stats page</title>

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
                    <li class="active"><a href="Servlet?method=read_stats">Statistics <span class="sr-only">(current)</span></a>
                    </li>
                    <li><a href="Servlet?method=read_top_news">Top News</a>
                    </li>
                    <li><a href="indexAjax.jsp">AJAX</a>
                </ul>
            </div>
    </nav>
</div>

<div class="container">
    <div class="row">

        <div class="col-md-12 text-center">
            <h2> Stats by region </h2>
        </div>
    </div>

    <div class="col-md-6">

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Region</th>
                    <th>Circulation</th>

                </tr>
            </thead>
            <tbody>

                <c:choose>
                    <c:when test="${not empty statnews}">
                        <c:forEach items="${statnews}" var="item">

                            <tr>
                                <th class="normal"> ${item.region}</th>
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
