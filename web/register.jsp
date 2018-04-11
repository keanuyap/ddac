<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Agent page</title>

        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/font-icons.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/responsive.css" />
        <link rel="stylesheet" href="css/spacings.css" />
        <link rel="stylesheet" href="css/colors/color-blue.css" />
    </head>
    <body>
        <form action ="RegisterAgent" method="post">
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
                                <h2>Register Page</h2> 
                                <br>
                                <div class="col-xs-12 pb20">
                                    <div class="col-md-4  col-xs-4 pb-20">Username:</div>

                                    <div class="col-md-4  col-xs-8 pb-20"><input type="text" name="id" class="col-md-8" required></div>
                                </div>
                                <div class="col-xs-12 pb20">
                                    <div class="col-md-4  col-xs-4 pb-20">Password:</div>

                                    <div class="col-md-4  col-xs-8 pb-20"><input type="password" name="password" class="col-md-8" required></div>
                                </div>
                                <div class="col-xs-12 pb20">
                                    <div class="col-md-4  col-xs-4 pb-20">Retype Pw:</div>

                                    <div class="col-md-4  col-xs-8 pb-20"><input type="password" name="repassword" class="col-md-8" required></div>
                                </div>
                                <div class="col-xs-12 pb20">
                                    <div class="col-md-4  col-xs-4 pb-20">First Name:</div>

                                    <div class="col-md-4  col-xs-8 pb-20"><input type="text" name="fname" class="col-md-8" required></div>
                                </div>
                                <div class="col-xs-12 pb20">
                                    <div class="col-md-4  col-xs-4 pb-20">Last Name:</div>

                                    <div class="col-md-4  col-xs-8 pb-20"><input type="text" name="lname" class="col-md-8" required></div>
                                </div>

                                <div class="col-xs-12 pb20">
                                    <div class="col-md-4  col-xs-4 pb-20">Gender:</div>

                                    <div class="col-md-4  col-xs-8 pb-20">
                                        <select name="gender" class="col-xs-10">
                                            <option name="Male">Male</option>
                                            <option name="Female">Female</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-xs-12 pb20">
                                    <div class="col-md-4  col-xs-4 pb-20">Type of user:</div>

                                    <div class="col-md-4  col-xs-8 pb-20">
                                        <select name="position" class="col-xs-10">
                                            <option name="nuser">Agent</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-xs-12 pb20">
                                    <div class="col-md-4  col-xs-4 pb-20">Status:</div>

                                    <div class="col-md-4  col-xs-8 pb-20">
                                        <select name="status" class="col-xs-10">
                                            <option name="Active">Active</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-xs-12 pb20">
                                    <div class="col-md-4  col-xs-4 pb-20">
                                        <button type="button" name="back" onclick="history.back()" class="col-xs-12" >Back</button>
                                    </div>
                                    <div class="col-md-4  col-xs-4 pb-20 col-xs-offset-2">
                                        <button type="submit" class="col-xs-12">Register</button>
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
