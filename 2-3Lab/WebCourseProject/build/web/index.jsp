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

        <title><fmt:message bundle="${msgs}" key="title.main"/></title>
        <meta name="description" content="Your description goes here." />
        <meta name="keywords" content="your, keywords, here" />
        <meta name="copyright" content="yourcompany.com" />

        <!-- jQuery -->
        <script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>

        <!-- jQuery slider plugin -->
        <script src="js/easySlider1.5.js" type="text/javascript" ></script>
    </head>


    <body id="home">
        <div id="wrapper">

            <div id="header">
                <!-- The name of your website -->
                <!--<h1><a href="index.html"><strong>Elementz</strong>Theme</a></h1> -->
                <!-- Tagline -->
                <!--<p class="tagline">Professional Theme for Your Needs</p> -->
                <a href="Servlet?command=ToMain">
                    <img src="img/logo.png" height="70" width="280"/>
                </a>
                <ul>
                    <!-- Navigation - the current page is highlighted with css class "current". -->
                    <li class="current">
                        <a href="Servlet?command=ToMain"><fmt:message bundle="${msgs}" key="menu.main.first"/>
                            <span class="navi-description"><fmt:message bundle="${msgs}" key="menu.main.second"/></span>
                        </a>
                    </li>
                    <li>
                        <a href="Servlet?command=ShowDishes&type=${0}"><fmt:message bundle="${msgs}" key="menu.dish.first"/>
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

            <div id="contentArea">
                <div id="intro">
                    <div id="slider">
                        <ul>
                            <li><img src="img/slider/cake1.jpg" alt="" /></li>
                            <li><img src="img/slider/cake2.jpg" alt="" /></li>
                            <li><img src="img/slider/cake3.jpg" alt="" /></li>
                            <li><img src="img/slider/cake4.jpg" alt="" /></li>
                        </ul>
                    </div><!-- End slider -->
                </div><!-- End intro -->
            </div><!-- End contentArea -->


            <div id="footerContent" >
                <div class="footerColumn enter">
                    <c:if test="${user!=null}">
                        <div class="top">
                            <br/>
                            Здравствуйте,<br/>
                            <c:out value="${user.getName()} !"/> <br/>
                            Вы вошли в систему.<br/><br/>
                        </div>
                        <form id="ExitUser" action="Servlet" method="post">
                            <input type="hidden" name="command" value="ExitUser" />
                            <input name="submit" type="image" id="submit" src="img/button_exit.jpg" style="margin:3px 10px 3px 10px; height:23px;"
                                   onclick="document.getElementById('ExitUser').submit()"/>
                        </form>
                    </c:if>
                    <c:if test="${user==null}">
                    <form id="EnterUser" action="Servlet" method="post">
                        <input type="hidden" name="command" value="EnterUser" />
                        <table>
                            <td>
                                <fmt:message bundle="${msgs}" key="user.login"/></br>
                                <fmt:message bundle="${msgs}" key="user.password"/>
                            </td>
                            <td>
                                <input name="login" type="text" class="side_menu_box_field" id="login" value="" size="11" /></br>
                                <input name="password" type="password" class="side_menu_box_field" id="password" value="" size="11" />
                            </td>
                        </table>
                        <a href="Servlet?command=ToRegistration">
                            <img src="img/button_reg.jpg" style="margin:3px 10px 3px 30px; height:23px;"/>
                        </a>
                        <input name="submit" type="image" id="submit" src="img/button_enter.jpg" style="margin:3px 10px 3px 10px; height:23px;"
                               onclick="document.getElementById('EnterUser').submit()"/>
                    </form>
                    </c:if>
                </div><!-- End footerColumn -->

                <div class="footerColumn">
                    Мы всегда благодарны вам за прекрасные рецепты. Ведь вы имеете возможность «обменяться» рецептами 
                    с жителями разных городов и стран. Разве это не прекрасная возможность познакомиться с кухней других 
                    народов или просто узнать оригинальные необычные рецепты, которые точно не найдешь в кулинарной книге?
                </div><!-- End footerColumn -->

                <div class="footerColumn last">
                    <div class="portfolioBox">
                        </br></br>
                        <p> Приятного аппетита! =)</p></br>
                    </div>
                </div><!-- End footerColumn -->

                <div id="footerLinks">
                    <p class="right"><fmt:message bundle="${msgs}" key="index.developer"/></p>
                </div><!-- End footerLinks -->
            </div><!-- End footerContent -->
        </div><!-- End wrapper -->

    </body>
</html>