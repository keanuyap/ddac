
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Ship page</title>

        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/font-icons.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/responsive.css" />
        <link rel="stylesheet" href="css/spacings.css" />
        <link rel="stylesheet" href="css/colors/color-blue.css" />
    </head>
    <body>
        <form action ="CheckDate" method="post">
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
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage Agent<b class="caret"></b></a>
                                                <ul class="dropdown-menu">
                                                    <li>
                                                        <a href="register.jsp">Register new Agent</a>
                                                    </li>
                                                    <li>
                                                        <a href="searchAgent.jsp">Search Agent</a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li class="dropdown">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage Ship<b class="caret"></b></a>
                                                <ul class="dropdown-menu">
                                                    <li>
                                                        <a href="registership.jsp">Register new Ship</a>
                                                    </li>
                                                    <li>
                                                        <a href="searchShip.jsp">Search Ship</a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li class="dropdown">
                                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage Schedule<b class="caret"></b></a>
                                                <ul class="dropdown-menu">
                                                    <li>
                                                        <a href="registerschedule.jsp">Register new Schedule</a>
                                                    </li>
                                                    <li>
                                                        <a href="searchSchedule.jsp">Search Schedule</a>
                                                    </li>                     
                                                </ul>
                                            </li>
                                            <li>
                                                <a href="managebooking.jsp">Manage Booking</a>
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

                        <div class="col-xs-12 pb-20">
                            <div class="about-description">
                                <h2>Register Schedule Page</h2> 
                                <br>
                                <div class="col-xs-12 pb20">
                                    <div class="col-md-4  col-xs-4 pb-20">Departure date:</div>

                                    <div class="col-md-4  col-xs-8 pb-20"><input type="date" name="ddate" class="col-md-8" required></div>
                                </div>
                                <div class="col-xs-12 pb20">
                                    <div class="col-md-4  col-xs-4 pb-20">Arrival Time:</div>

                                    <div class="col-md-4  col-xs-8 pb-20"><input type="date" name="adate" class="col-md-8" required></div>
                                </div>
                                <div class="col-xs-12 pb20">
                                    <div class="col-md-4  col-xs-4 pb-20">
                                        <button type="button" name="back" onclick="history.back()" class="col-xs-12" >Back</button>
                                    </div>
                                    <div class="col-md-4  col-xs-4 pb-20 col-xs-offset-2">
                                        <button type="submit" class="col-xs-12">Check available Ship</button>
                                    </div>
                                </div>
                            </div>  
                        </div>
                    </div> <!-- end col -->

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
