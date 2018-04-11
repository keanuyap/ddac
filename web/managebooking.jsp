
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.MLuser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Schedule Page</title>
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
        <form action ="SearchABooking" method="post">
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
                            <h2 class="intro-heading caps">Search Booking</h2>

                            <br><br>
                        </div>
                        <div class="col-sm-10 col-sm-offset-1">

                            <div class="col-sm-3 col-sm-offset-1"></div>

                            <button type="submit" class="col-sm-3 col-sm-offset-1" value="ShowAll" name="button">Show All</button>
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
                                            Booking ID
                                        </th>
                                        <th class="col-md-1">
                                            Schedule ID
                                        </th>
                                        <th class="col-md-2"> 
                                            Item ID
                                        </th>

                                        <th class="col-md-1">
                                            Agent ID
                                        </th>
                                        <th class="col-md-1">
                                            Status
                                        </th>
                                    </tr>


                                    <c:forEach items="${BKresult}" var="BKresult">
                                        <tr>
                                            <td class="col-md-1">${BKresult.id}</td>
                                            <td class="col-md-2">${BKresult.scid.id}</td>
                                            <td class="col-md-2">${BKresult.iid.id}</td>
                                            <td class="col-md-1">${BKresult.uid.id}</td>
                                            <td class="col-md-1">${BKresult.status}</td>
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
        <form action ="ManageBooking" method="post">
            <section class="section-wrap services style-2 bg-light pb-90" id="updatepage">
                <div class="container" >
                    <div class="row pb-20">
                        <h2 class="center-block">Update Page</h2>
                        <div class="col-md-12">
                            <div class="col-md-6">
                                <div class="col-md-4 ">Booking ID:</div><div><input type="text" id="id" name="id" class="col-md-8" readonly></div>
                            </div>
                            <div class="col-md-6">
                                <div class="col-md-4 ">Agent ID:</div><div><input type="text" id="uid" name="uid" class="col-md-8" readonly></div>
                            </div>
                        </div>
                        <br><br>
                        <div class="col-md-12">
                            <div class="col-md-6">
                                <div class="col-md-4 ">Item ID:</div><div><input type="text" id="iid" name="iid" class="col-md-8" readonly></div>
                            </div>
                            <div class="col-md-6">
                                <div class="col-md-4 ">Schedule ID:</div><div><input type="text"  id="scid" name="scid" class="col-md-8" readonly></div>
                            </div>
                        </div>
                        <br><br>
                        <div class="col-md-12">
                            <div class="col-md-6">
                                <div class="col-md-4 " class="col-md-8">Status:</div>
                                <div>
                                    <select  id="status" name="status" class="col-md-8">
                                        <option name="Active">Approve</option>
                                        <option name="Deactive">Reject</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <br><br>
                        <div class="col-sm-10 col-sm-offset-1">

                            <div class="col-sm-3 col-sm-offset-1"></div>

                            <button type="submit" class="col-sm-3 col-sm-offset-1" value="Confirm" name="button">Confirm</button>
                            <br><br>
                        </div> 
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
        <script>

            function rowselected() {
                var table = document.getElementById("table");
                for (var i = 1; i < table.rows.length; i++) {
                    table.rows[i].onclick = function () {
                        ctable = this.rowIndex;
                        document.getElementById("id").value = this.cells[0].innerHTML;
                        document.getElementById("scid").value = this.cells[1].innerHTML;
                        document.getElementById("iid").value = this.cells[2].innerHTML;
                        document.getElementById("uid").value = this.cells[3].innerHTML;
                    };
                }

            }
            rowselected();

        </script>
    </body>
</html>
