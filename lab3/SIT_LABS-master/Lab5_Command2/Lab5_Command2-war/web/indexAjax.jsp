<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
        <html lang="en">

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
            <title>Main page</title>

            <!-- Bootstrap -->
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
                            <li ><a href="Servlet?method=read_news">Main </a>
                            </li>
                            <li><a href="Servlet?method=read_stats">Statistics</a>
                            </li>
                            <li><a href="Servlet?method=read_top_news">Top News</a>
                            </li>

                            <li class="active"><a href="indexAjax.jsp">AJAX <span class="sr-only">(current)</span></a>

                        </ul>


                    </div>
            </nav>

            <div class="container">
                <div class="row">

                    <div class="col-md-12">
                        <h2> All news are shown here: </h2>
                    </div>
                </div>


                <div class="col-md-8">

                    <table class="table table-striped" id="myTable">
                        <thead>
                            <tr>
                                <th>News_name</th>
                                <th>Circulation</th>
                                <th>Publish date</th>
                                <th>Region</th>
                                <th>Author</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>text</td>
                                <td>text</td>
                                <td>text</td>
                                <td>text</td>
                                <td>text</td>
                            </tr>
                        </tbody>
                    </table>

                </div>

                <div class="col-md-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Manage that shit</div>
                        <div class="panel-body">
                            <form role="form" action="AjaxServlet">

                                <div class="form-group">
                                    <label for="News_name">News_name:</label>
                                    <input type="text" class="form-control" id="News_name" placeholder="Enter news_name" name="name">
                                </div>

                                <div class="form-group">
                                    <label for="circ">Circulation:</label>
                                    <input type="text" class="form-control" id="circ" placeholder="Enter circulation num" name="circulation">
                                </div>

                                <div class="form-group">
                                    <label for="pub_date">Publish date:</label>
                                    <input type="date" class="form-control" id="pub_date" placeholder="Enter publish date" name="publishDate">
                                </div>

                                <div class="form-group">
                                    <label for="country">Country:</label>
                                    <input type="text" class="form-control" id="country" placeholder="Enter country" name="region">
                                </div>

                                <div class="form-group">
                                    <label for="auth">Author:</label>
                                    <input type="text" class="form-control" id="author" placeholder="Enter author" name="authorName">
                                </div>

      
                                
                                <input type="hidden" value="add_ajax" name="method" />

                            </form>
                                                      <button type="submit" class="btn btn-default" value="Add" id="myButtonAdd">Add</button>
                             <button class="btn btn-default" value="ReadAjax" id="myButton">Read</button>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">


                </div>


                <hr>



                <!-- Include all compiled plugins (below), or include individual files as needed -->
                <script src="jQuery/jquery.js"></script>
                <script src="jQuery/myjs.js"></script>
                <script src="js/bootstrap.min.js"></script>
                <script src="js/offcanvas.js"></script>
        </body>

        </html>