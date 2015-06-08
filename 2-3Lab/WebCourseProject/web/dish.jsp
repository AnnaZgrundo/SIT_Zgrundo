<%-- 
    Document   : dish
    Created on : 23.05.2015, 20:50:52
    Author     : ko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:setBundle basename="by.bsuir.course.Zgrundo.resource.message" var="msgs" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <link rel="shortcut icon" href="img/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="css/default.css" title="default" />

        <title><fmt:message bundle="${msgs}" key="title.dish"/></title>
        <meta name="description" content="Your description goes here." />
        <meta name="keywords" content="your, keywords, here" />
        <meta name="copyright" content="yourcompany.com" />

        <!-- jQuery -->
        <script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>

        <!-- jQuery slider plugin -->
        <script src="js/easySlider1.5.js" type="text/javascript" ></script>
    </head>


    <body>
        <div id="wrapper">
            <div id="header">
                <a href="Servlet?command=ToMain">
                    <img src="img/logo.png" height="70" width="280"/>
                </a>
                <ul>
                    <!-- Navigation - the current page is highlighted with css class "current". -->
                    <li>
                        <a href="Servlet?command=ToMain"><fmt:message bundle="${msgs}" key="menu.main.first"/>
                            <span class="navi-description"><fmt:message bundle="${msgs}" key="menu.main.second"/></span>
                        </a>
                    </li>
                    <li class="current">
                        <a href="Servlet?command=ShowDishes"><fmt:message bundle="${msgs}" key="menu.dish.first"/>
                            <span class="navi-description"><fmt:message bundle="${msgs}" key="menu.dish.second"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="Servlet?command=ShowFavourite"><fmt:message bundle="${msgs}" key="menu.favourite.first"/>
                            <span class="navi-description"><fmt:message bundle="${msgs}" key="menu.favourite.second"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="Servlet?command=ToCabinet"><fmt:message bundle="${msgs}" key="menu.cabinet.first"/>
                            <span class="navi-description"><fmt:message bundle="${msgs}" key="menu.cabinet.second"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="Servlet?command=ToInfo"><fmt:message bundle="${msgs}" key="menu.info.first"/>
                            <span class="navi-description"><fmt:message bundle="${msgs}" key="menu.info.second"/></span>
                        </a>
                    </li>
                </ul><!-- End navigation -->

            </div><!-- End header -->

            <div id="contentArea" >

                <div id="secondaryContent">
                    <ul>
                        <li><a href="Servlet?command=ShowDishes&type=1"><img src="img/dish/meet.jpg" width="130"><br/></a></li>
                        <li><a href="Servlet?command=ShowDishes&type=2"><img src="img/dish/salads.jpg" width="90"><br/></a></li>
                        <li><a href="Servlet?command=ShowDishes&type=3"><img src="img/dish/cakes.jpg" width="140"><br/></a></li>
                        <li><a href="Servlet?command=ShowDishes&type=4"><img src="img/dish/drink.jpg" width="90"><br/></a></li>
                    </ul>
                </div><!-- End secondaryContent -->

                <div id="primaryContent">

                    <p class="breadcrumbs">Сейчас вы здесь: <a href="index.jsp">Главная</a> &raquo; <a href="Servlet?command=ShowDishes">Блюда</a></p>

                    <div id="dish_main">
                        <c:if test="${dishList.size()>3}" >
                            <div id="slider">
                                <c:set var="n" value="${dishList.size()}"/>
                                <c:set var="i_first" value="0"/>
                                <c:set var="n_slides" value="${n/3}"/>
                                <ul>
                                    <c:forEach var="n_sl" begin="1" end="${n_slides}" >
                                        <li>
                                            <table id="table_dish" >
                                                <c:forEach var="i" begin="${i_first}" end="${i_first+2}">
                                                    <tr>
                                                        <td>
                                                            <a href="Servlet?command=ShowOneDish&dishID=${dishList.get(i).getIdDish()}">
                                                                <img src="${dishList.get(i).getPicture()}" width="215" height="130"  alt="icon"/>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <a href="Servlet?command=ShowOneDish&dishID=${dishList.get(i).getIdDish()}">
                                                                <c:out value="${dishList.get(i).getName()}"/>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        </li>
                                        <c:set var="i_first" value="${i_first+3}"/>
                                    </c:forEach>
                                </ul>
                            </div><!-- End slider -->
                        </c:if>
                        <c:if test="${dishList.size()<=3}">
                            <table id="table_dish" >
                                <c:forEach var="i" begin="${i_first}" end="${i_first+2}">
                                    <tr>
                                        <td>
                                            <a href="Servlet?command=ShowOneDish&dishID=${dishList.get(i).getIdDish()}">
                                                <img src="${dishList.get(i).getPicture()}" width="215" height="130"  alt="icon"/>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a href="Servlet?command=ShowOneDish&dishID=${dishList.get(i).getIdDish()}">
                                                <c:out value="${dishList.get(i).getName()}"/>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>

                    </div>

                </div><!-- End footerColumn -->



            </div><!-- End contentArea -->

        </div><!-- End wrapper -->
    </body>
</html>
