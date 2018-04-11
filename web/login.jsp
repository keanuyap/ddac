<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/responsive.css" />
        <link rel="stylesheet" href="css/spacings.css" />
        <link rel="stylesheet" href="css/colors/color-blue.css" />
    </head>
    <body>
        <form action ="Login" method="post">
            <header class="nav-type-2">

                <nav class="navbar navbar-static-top">
                    <div class="navigation">
                        <div class="container relative">
                            <div class="row col-md-12">
                                <div class="col-md-3"><br><h1>Maersk Line CSM</h1></div>
                            </div> <!-- end row -->
                        </div> <!-- end container -->
                    </div> <!-- end navigation -->
                </nav> <!-- end navbar -->
            </header> <!-- end navigation -->
            <section class="section-wrap">
                <div class="container">
                    <div class="row">

                        <div class="col-md-12 col-xs-12 pb-20">
                            <div class="about-description">
                                <h2>Login Page</h2> 
                                <br>
                                <div class="col-md-6  col-xs-4 pb-20">Username:</div>

                                <div class="col-md-6  col-xs-8 pb-20"><input type="text" name="id" class="col-md-8"></div>
                                <br><br>
                                <div class="col-md-6  col-xs-4 pb-20">Password:</div>

                                <div class="col-md-6  col-xs-8 pb-20"><input type="password" name="password" class="col-md-8"></div>
                                
                                <div class="col-md-6  col-xs-4 pb-20"></div>

                                <div class="col-md-6  col-xs-8 pb-20"> <button type="submit" class="col-md-8" >Login</button></div>

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
