<%@page import="model.MLuser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agent Home Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/responsive.css" />
        <link rel="stylesheet" href="css/spacings.css" />
        <link rel="stylesheet" href="css/colors/color-blue.css" />
    </head>
    <body>

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
                </div>
            </div>
        </section>
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
