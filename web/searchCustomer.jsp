
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.MLuser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Customer Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/responsive.css" />
        <link rel="stylesheet" href="css/spacings.css" />
        <link rel="stylesheet" href="css/colors/color-blue.css" />
    </head>
    <body>
        <style>
            th {border: 1px solid;}
            td {border: 1px solid;}
            tr:hover td{background-color: #14b8ee;
                        cursor: pointer;}

        </style>
        <form action ="SearchCustomer" method="post">
            <header class="nav-type-2">

                <nav class="navbar navbar-static-top">
                    <div class="navigation">
                        <div class="container relative">
                            <div class="row col-md-12">

                                <div class="col-md-3"><h2>Maersk Line CSM</h2></div>

                                <div class="col-md-9 nav-wrap">
                                    <div class="collapse navbar-collapse" id="navbar-collapse">

                                        <ul class="nav navbar-nav navbar-right">
                                            <li class="dropdown">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage Customer<b class="caret"></b></a>
                                                <ul class="dropdown-menu">
                                                    <li>
                                                        <a href="registercustomer.jsp">Register new Customer</a>
                                                    </li>
                                                    <li>
                                                        <a href="searchCustomer.jsp">Search Customer</a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li class="dropdown">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage Item<b class="caret"></b></a>
                                                <ul class="dropdown-menu">
                                                    <li>
                                                        <a href="registeritem.jsp">Register new Item</a>
                                                    </li>
                                                    <li>
                                                        <a href="searchItem.jsp">Search Item</a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li class="dropdown">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage Booking<b class="caret"></b></a>
                                                <ul class="dropdown-menu">
                                                    <li>
                                                        <a href="searchOSchedule.jsp">Make Booking</a>
                                                    </li>
                                                    <li>
                                                        <a href="searchBooking.jsp">Search Booking</a>
                                                    </li>
                                                </ul>
                                            </li>     
                                            <li>
                                                <a href="Logout">Logout</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div> <!-- end col -->

                            </div> <!-- end row -->
                        </div> <!-- end container -->
                    </div> <!-- end navigation -->
                </nav> <!-- end navbar -->
            </header> <!-- end navigation -->
            <section class="section-wrap">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="about-description">
                                <h2>
                                    <% HttpSession s = request.getSession(false);
                                        MLuser e = (MLuser) s.getAttribute("MLuser");
                                        if (e.getGender().equals("Male")) {
                                            out.println("Welcome, Mr." + e.getLname());
                                        } else {
                                            out.println("Welcome, Ms." + e.getLname());
                                        }%>
                                </h2>
                            </div>
                        </div> <!-- end col -->
                        <br><br>
                        <div class="col-xs-10 col-xs-offset-1 text-center">
                            <h2 class="intro-heading caps">Search Customer</h2>

                            <div class="col-sm-4" align="left">Enter Keyword: </div>

                            <div><input type="text" name="Ckeyword" class="col-sm-8"></div>
                            <br><br>
                            <div class="col-sm-4" align="left">Select Categories: </div>

                            <div><select name="CCategories" class="col-md-8">
                                    <option value="id">Customer ID</option>
                                    <option value="cname">Customer Name</option>
                                    <option value="address">Address</option>
                                    <option value="gender">Gender</option>
                                </select>
                            </div>
                            <br><br>
                        </div>
                        <div class="col-sm-10 col-sm-offset-1">

                            <div class="col-sm-3 col-sm-offset-1"></div>
                            <button type="submit" class="col-sm-3 col-sm-offset-1" value="ShowAll" name="button">Show All</button>
                            <button type="submit" class="col-sm-3 col-sm-offset-1" value="Search" name="button">Search</button>
                            <br><br>
                        </div> 
                    </div>
                </div>
            </section>
            <section class="section-wrap services style-2 bg-light pb-90">
                <div class="container" >
                    <div class="row pb-20">
                        <div class="col-md-20 text-center pb-20">
                            <h2 class="intro-heading caps">Search Result</h2>
                            <div class="col-md-15">
                                <table id="table">
                                    <tr>
                                        <th class="col-md-1">
                                            Customer ID
                                        </th>
                                        <th class="col-md-2"> 
                                            Customer Name
                                        </th>
                                        <th class="col-md-1">
                                            Address
                                        </th>
                                        <th class="col-md-1">
                                            Gender
                                        </th>
                                    </tr>


                                    <c:forEach items="${Cresult}" var="cresult">
                                        <tr>
                                            <td class="col-md-1">${cresult.id}</td>
                                            <td class="col-md-2">${cresult.cname}</td>
                                            <td class="col-md-1">${cresult.address}</td>
                                            <td class="col-md-1">${cresult.gender}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div> 
                            <br><br> 
                        </div> <!-- end col -->
                    </div>
                </div>
            </section>
        </form>
        <!-- jQuery Scripts -->
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/plugins.js"></script>
        <script type="text/javascript" src="revolution/js/jquery.themepunch.tools.min.js"></script>
        <script type="text/javascript" src="revolution/js/jquery.themepunch.revolution.min.js"></script>
        <script type="text/javascript" src="js/rev-slider.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
    </body>
</html>
