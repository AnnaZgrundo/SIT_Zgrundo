<%-- 
    Document   : cabinet
    Created on : 23.05.2015, 21:02:35
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

        <title><fmt:message bundle="${msgs}" key="title.cabinet"/></title>
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
                    <li>
                        <a href="Servlet?command=ShowDishes"><fmt:message bundle="${msgs}" key="menu.dish.first"/>
                            <span class="navi-description"><fmt:message bundle="${msgs}" key="menu.dish.second"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="Servlet?command=ShowFavourite"><fmt:message bundle="${msgs}" key="menu.favourite.first"/>
                            <span class="navi-description"><fmt:message bundle="${msgs}" key="menu.favourite.second"/></span>
                        </a>
                    </li>
                    <li class="current">
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
                <c:if test="${user==null}" >
                    <p class="breadcrumbs">Сейчас вы здесь: <a href="index.jsp">Главная</a> &raquo; <a href="#">Мой кабинет</a></p>
                    <p><br/><br/>Этот раздел активен только для зарегистрированных пользователей.
                        <br/>Для получения доступа войдите в систему или зарегистрируйтесь.
                    </p>
                </c:if>

                <c:if test="${user!=null}" >
                    <div id="secondaryContent">
                        <br/><br/>
                        <br/>
                        <br/>
                        <ul class="secondaryNavi">
                            <li><a href="Servlet?command=ToCabinet&typeCabinet=1">Редактировать профиль</a></li><br/>
                        </ul>
                    </div><!-- End secondaryContent -->

                    <div id="primaryContent">
                        <p class="breadcrumbs">Сейчас вы здесь: <a href="index.jsp">Главная</a> &raquo; <a href="#">Мой кабинет</a></p>

                        <c:if test="${typeCabinet==1}">
                            <form id="EditUser" action="Servlet" method="post">
                                <input type="hidden" name="command" value="EditUser" />
                                <table cellpadding="25" style="border:0px; margin:auto;">
                                    <tr>
                                        <td width="300" align="right">
                                            <p><font><fmt:message bundle="${msgs}" key="add.login"/></font></p>
                                        </td>
                                        <td width="150">
                                            <p><input name="login" pattern="[A-Z]+" value="${user.getLogin()}" type="text" required /></p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="50" align="right">
                                            <p><font><fmt:message bundle="${msgs}" key="add.password"/></font></p>
                                        </td>
                                        <td width="190">
                                            <p><input name="password" pattern="[A-Z]+" type="text" required /></p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right">
                                            <p><font><fmt:message bundle="${msgs}" key="add.password2"/></font></p>
                                        </td>
                                        <td>
                                            <p><input name="password2" pattern="[A-Z]+" type="text" required /></p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right">
                                            <p><font><fmt:message bundle="${msgs}" key="add.name"/></font></p>
                                        </td>
                                        <td>
                                            <p><input name="name" pattern="[a-zA-Zа-яА-Я]+" value="${user.getName()}" type="text" /></p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right">
                                            <c:if test="${error!=null}">
                                                <div style="color:red; font-style:italic;">
                                                    <p><c:out value="${error}" /></p>
                                                </div>
                                            </c:if>
                                        </td>
                                        <td align="center">
                                            <input type="button" value="OK" onclick="document.getElementById('EditUser').submit()" />
                                        </td>
                                    </tr>
                                </table>
                            </c:if>

                            <c:if test="${typeCabinet==2}">
                                <form id="AddDish" action="Servlet" method="post">
                                <input type="hidden" name="command" value="AddDish" />
                                <table cellpadding="25" style="border:0px; margin:auto;">
                                    <tr>
                                        <td width="300" align="right">
                                            <p><font><fmt:message bundle="${msgs}" key="add.login"/></font></p>
                                        </td>
                                        <td width="150">
                                            <p><input name="login" pattern="[A-Z]+" value="${user.getLogin()}" type="text" required /></p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td width="50" align="right">
                                            <p><font><fmt:message bundle="${msgs}" key="add.password"/></font></p>
                                        </td>
                                        <td width="190">
                                            <p><input name="password" pattern="[A-Z]+" type="text" required /></p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right">
                                            <p><font><fmt:message bundle="${msgs}" key="add.password2"/></font></p>
                                        </td>
                                        <td>
                                            <p><input name="password2" pattern="[A-Z]+" type="text" required /></p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right">
                                            <p><font><fmt:message bundle="${msgs}" key="add.name"/></font></p>
                                        </td>
                                        <td>
                                            <p><input name="name" pattern="[a-zA-Zа-яА-Я]+" value="${user.getName()}" type="text" /></p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="right">
                                            <c:if test="${error!=null}">
                                                <div style="color:red; font-style:italic;">
                                                    <p><c:out value="${error}" /></p>
                                                </div>
                                            </c:if>
                                        </td>
                                        <td align="center">
                                            <input type="button" value="OK" onclick="document.getElementById('AddDish').submit()" />
                                        </td>
                                    </tr>
                                </table>
                            </c:if>

                            <c:if test="${typeCabinet==3}">

                            </c:if>
                    </div>
                </c:if>








            </div><!-- End contentArea -->

        </div><!-- End wrapper -->
    </body>
</html>
