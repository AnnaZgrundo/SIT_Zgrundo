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
                    <p class="breadcrumbs">Сейчас вы здесь: <a href="index.jsp">Главная</a> 
                        &raquo; <a href="Servlet?command=ShowDishes">Блюда</a>
                        &raquo; <c:out value="${dish.getName()}"/></a></p>
                        <c:set var="n" value="${listIngr.size()}"/>
                    <table id="table_recipe" cellpadding="5" >
                        <tr>
                            <td rowspan="${n+1}" width="350">
                                <img src="${dish.getPicture()}" height="230" alt="icon" />
                            </td>
                            <td colspan="2" width=300">
                                <p><c:out value="${dish.getName()}"/></p>
                            </td>
                        </tr>
                        <c:set var="i" value="0" />
                        <c:forEach items="${listIngr}" var="ingr">
                            <tr>
                                <td>
                                    <c:out value="${ingr.getIngredient()}"/>
                                </td>
                                <td>
                                    <c:out value="${listW.get(i)}"/> г.
                                </td>
                            </tr>
                            <c:set var="i" value="${i+1}" />
                        </c:forEach>
                        <tr c>
                            <td colspan="3">
                                <br/><c:out value="${dish.getCookingMethod()}"/>
                            </td> 
                        </tr>
                        <tr>
                            <td>
                                <c:if test="${error!=null}">
                                    <div id="error">
                                        <p><c:out value="${error}" /></p>
                                    </div>
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${user!=null}">
                                    <p>
                                        <form id="AddFavourite" action="Servlet" method="post">
                                            <input type="hidden" name="command" value="AddFavourite" />
                                            <input type="hidden" name="dishID" value="${dish.getIdDish()}" />
                                            <input type="hidden" name="userID" value="${user.getIdUser()}" />
                                            <input name="submit" type="image" class="side_menu_box_button" id="submit" src="img/button_fav.jpg" height="30"
                                                   onclick="document.getElementById('AddFavourite').submit()"/>
                                        </form>
                                    </p>
                                </c:if>
                            </td>
                        </tr>
                    </table>
                </div><!-- End footerColumn -->



            </div><!-- End contentArea -->

        </div><!-- End wrapper -->
    </body>
</html>
