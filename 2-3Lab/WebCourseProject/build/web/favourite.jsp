<%-- 
    Document   : favourite
    Created on : 23.05.2015, 21:01:18
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

        <title><fmt:message bundle="${msgs}" key="title.favourite"/></title>
        <meta name="description" content="Your description goes here." />
        <meta name="keywords" content="your, keywords, here" />
        <meta name="copyright" content="yourcompany.com" />

        <!-- jQuery -->
        <script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>

        <!-- Lightbox Plugin -->
        <link rel="stylesheet" href="css/lightbox.css" type="text/css" />
        <script src="js/jquery.lightbox.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $(".lightbox").lightbox();
            });
        </script>

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
                    <li>
                        <a href="Servlet?command=ShowDishes"><fmt:message bundle="${msgs}" key="menu.dish.first"/>
                            <span class="navi-description"><fmt:message bundle="${msgs}" key="menu.dish.second"/></span>
                        </a>
                    </li>
                    <li class="current">
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
                <c:if test="${user==null}" >
                    <p class="breadcrumbs">Сейчас вы здесь: <a href="index.jsp">Главная</a> &raquo; <a href="#">Любимое</a></p>
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
                            <li><a href="#">Любимое</a></li><br/>
                        </ul>
                    </div><!-- End secondaryContent -->

                    <div id="primaryContent">
                        <p class="breadcrumbs">Сейчас вы здесь: <a href="index.jsp">Главная</a> &raquo; <a href="#">Любимое</a></p>
                        <br/><br/><br/>
                        <div id="fav_main">
                            <c:if test="${favList.size()==0}">
                                У вас нет любимых блюд. =(
                            </c:if>
                            <c:if test="${favList.size()>4}" >
                                <div id="slider">
                                    <c:set var="n" value="${favList.size()}"/>
                                    <c:set var="i_first" value="0"/>
                                    <c:set var="i_second" value="${i_first+3}"/>

                                    <ul>
                                        <c:forEach var="n_sl" begin="1" end="${n_slides}" >
                                            <li>
                                                <c:forEach var="i" begin="${i_first}" end="${i_second}">
                                                    <div class="portfolioBox">
                                                        <div class="close">
                                                            <a href="Servlet?command=DeleteFavourute&id=${favList.get(i).getIdFavourite()}"><img src="img/lightbox/close.gif"</a>
                                                        </div>

                                                        <a href="${favList.get(i).getDish().getPicture()}" class="lightbox" rel="gallery">
                                                            <img src="${favList.get(i).getDish().getPicture()}" alt="" title="" />
                                                            <h3><c:out value="${favList.get(i).getDish().getName()}" /></h3>
                                                            <p><c:out value="${favList.get(i).getDish().getType().getType()}" /></p>
                                                        </a>
                                                    </div>
                                                </c:forEach> 
                                            </li>
                                            <c:set var="i_first" value="${i_first+4}"/>
                                            <c:if test="${(i_first+3) > n}">
                                                <c:set var="i_second" value="${n-1}"/>
                                            </c:if>
                                            <c:if test="${(i_first+3) <= n}">
                                                <c:set var="i_second" value="${i_first+3}"/>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </div><!-- End slider -->
                            </c:if>
                            <c:if test="${favList.size()<=4}">
                                <c:forEach items="${favList}" var="favourite">
                                    <div class="portfolioBox">
                                        <div class="close">
                                            <a href="Servlet?command=DeleteFavourute&id=${favourite.getIdFavourite()}"><img src="img/lightbox/close.gif"</a>
                                        </div>

                                        <a href="${favourite.getDish().getPicture()}" class="lightbox" rel="gallery">
                                            <img src="${favourite.getDish().getPicture()}" alt="" title="" />
                                            <h3><c:out value="${favourite.getDish().getName()}" /></h3>
                                            <p><c:out value="${favourite.getDish().getType().getType()}" /></p>
                                        </a>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>
                    </div><!-- End contentArea -->
                </c:if>
            </div><!-- End wrapper -->
    </body>
</html>

