
<%-- 
    Document   : login
    Created on : 20 Jul, 2019, 12:26:14 PM
    Author     : nafees
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script src="/E-Commerce/JS/registration.js"></script>
        <script src="/E-Commerce/JS/loginjs.js"></script>

        <title>JSP Page</title>
    </head>
    <link href="/E-Commerce/CSS/LoginPage.css" rel="stylesheet" type="text/css"/>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <body>

        <nav class="navbar navbar-expand-md bg-dark navbar-dark navbar navbar-fixed-top">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item">


                    </li>
                    <li class="nav-item">
                        <div class="form-check ">
                            <form action="fc/?page=Search&type=model" method="post">
                                <ul class="navbar-nav ml-auto">
                                    <li style="list-style: none;"> <input class="form-control" id="searchid" onblur="searchModel('searchid', 'sid')" name="search" type="text" placeholder="Search anythings..."><span id="sid"></span></li>
                                    <li style="padding-left: 20px;">   <input type="submit" class="btn btn-primary"></li>
                                </ul>
                            </form>
                        </div>
                    </li>

                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <button type="button" class="btn btn-primary btn-md navbar-toggle collapsed pull-left" data-toggle="modal" data-target="#myModal">signup</button>

                    </li>
                    <li class="nav-item" style="padding-left: 20px;">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#SignModal">
                            login
                        </button>
                    </li>

                </ul>
            </div>  
        </nav>


        <div class="container-fluid" style="background-color: activecaption;width: 100%">
            <div class="row">
                <div clas ="col-md-12 col-lg-12 col-sm-12" style="height: 60px;width: 100%;background-color: aqua">

                </div>


            </div>
            <div class="row">
                <div class="col-md-12  col-lg-12 col-sm-12">


                    <!-- The Modal -->
                    <div class="modal fade" id="SignModal" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title"></h4>
                                    <button type="button" class="fade" data-dismiss="modal">&times;</button>
                                  
                                    <button type="button" class="btn btn-primary btn-lg" style="float: left;">Login</button>
                                </div>

                                <!-- Modal body -->
                                <div class="modal-body">
                                    <form action="fc/?page=Login&type=model" method="post"><br>
                                        <label for="email">Email</label>
                                        <input class="form-control" id="eid" onblur="loginVerify('eid', 'sid')" type="text" name="email" placeholder="username"><span id="sid"></span><br>
                                        <label for="pwd">Password</label>
                                        <input class="form-control" type="password" name="pass" placeholder="password"><br>
                                        <div class="form-group form-check">
                                            <label class="form-check-label">
                                                <input class="form-check-input" type="checkbox"> Remember me
                                            </label>
                                        </div>
                                        <input type="submit" name="login" class="btn btn-primary">
                                        <a href="fc/?page=forgetpassword&type=view">forget password ?</a>


                                    </form>


                                </div>

                                <!-- Modal footer -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="row">
                <div class="col-md-4  col-lg-4 col-sm-4">

                </div>
                <div class="col-md-4  col-lg-4 col-sm-4">


                    <!-- Modal -->
                    <div id="myModal" class="modal fade" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="fade" data-dismiss="modal">&times;</button>
                                    <button type="button" class="btn btn-primary btn-lg" style="float: left">Registration</button>



                                </div>
                                <div class="modal-body">
                                    <form action="fc/?page=Registration&type=model" method="post">


                                        <input class="form-control" type="text" name="email" placeholder="Email" id="eeid" onblur="aCaller('eeid', 'errid')">
                                        <span id="errid"></span><br></li>

                                        <li style="list-style: none;"><input class="form-control" type="password" placeholder="Password" id="pid" onblur="validator('pid', 'errorpid')" name="pass" >
                                            <span id="errorpid"></span><br></li>

                                        <li style="list-style: none;"><input class="form-control" type="text" placeholder="First Name" name="fname" id="fname" onblur="validator('fname', 'errorfname')" ><span id="errorfname"></span><br></li>

                                        <li style="list-style: none;"><input class="form-control" type="text" placeholder="Last Name" id="lname" name="lname" onblur="validator('lname', 'errorlname')"><span id="errorlname"></span><br></li>

                                        <li style="list-style: none;">  <input class="form-control" type="text" placeholder="Phone" id="phoneid" onblur="validator('phoneid', 'errorphoneid')" name="phone" ><span
                                                id="errorphoneid"></span><br></li>
                                        <!--    <select name="city">
                                                <option value="1">Zamania</option
                                                <option value="2">Lucknow</option>
                                                <option value="3">Varanasi</option>
    
                                            </select> -->

                                        <input class="btn btn-info" type="submit" value="register">




                                    </form>



                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-lg-4 col-sm-4">

                </div>


            </div>

            <% for (int i = 0; i < 5; i++) { %>

            <div class="row">
                <div class="col-sm-4 col-lg-4 col-sm-4">
                    <div class="card" style="width:400px">
                        <img class="card-img-top" src="/E-Commerce/images/image1.jpg" alt="Card image" style="width:400px;height: 170px;">
                        <div class="card-body">

                            <a href="fc/?page=AddToCart&type=model&pid=123&cat=Electronics" class="btn btn-primary btn btn-sm">Buy</a>

                        </div>
                    </div>
                </div>
                <div class="col-sm-4  col-lg-4 col-md-4">
                    <div class="card" style="width:400px">
                        <img class="card-img-top" src="/E-Commerce/images/image2.jpg" alt="Card image" style="width:400px;height:170px;">
                        <div class="card-body">
                            <a href="fc/?page=AddToCart&type=model&pid=123&cat=Electronics" class="btn btn-primary btn btn-sm">Buy</a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4 col-lg-4 col-md-4">

                    <div class="card" style="width: 300px;">
                        <img class="card-img-top" src="/E-Commerce/images/image3.jpg" alt="Card image" style="width:300px;height:170px;">
                        <div class="card-body">

                            <a href="fc/?page=AddToCart&type=model&pid=123&cat=Electronics" class="btn btn-primary btn btn-sm">Buy</a>
                        </div>
                    </div>

                </div>
                <div class="row" style="height: 20px;width: 100%;"></div>
            </div>


            <% }%>
        </div>



        <footer id="footer">
            <div class="footer-top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 col-md-6 footer-info"> <br><br>
                            <h3>LEND-A-HAND</h3>
                            <p> Its an e- Commerse Website created for the students where they can buy new as well as used products which are being sold by other Students</p>
                        </div>
                        <div class="col-lg-2 col-md-6 footer-links"><br><br>
                            <h4> Usefull Links</h4>
                            <ul>
                                <li><a href="#">Link</a></li>
                                <li><a href="#">Link</a></li>

                            </ul>
                        </div>
                        <div class="col-lg-3 col-md-6 footer-contact"><br><br>
                            <h4>Contact Us</h4>
                            <p>
                                Integral University<br/>
                                Kursi Road, Lucknow<br/>
                                India<br/>
                                <strong>Phone: +916393545132</strong><br/>
                                <strong>Email: contact.nafees12@gmail.com</strong><br/>
                            </p>

                        </div>
                        <div class="col-lg-3 col-md-6 footer-newsletter"><br><br>
                            <h4>Our Newsletter</h4>
                            <p>  ---------------------------------------------------------------------------------</p>
                            <form accept="" method="post">
                                <input type="email" name="email"><input type="submit" value="Subscribe"></form>
                        </div>
                    </div>
                </div>
            </div>

        </footer>

        
        

    </body>
</html>
