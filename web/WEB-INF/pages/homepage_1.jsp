<%-- 
    Document   : homepage
    Created on : 17 Sep, 2019, 12:21:49 PM
    Author     : nafees
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-md bg-dark navbar-dark navbar navbar-fixed-top">
            <a class="navbar-brand" href="/E-Commerce/fc/?page=login&type=view">Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item">


                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>    
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <form action="fc/?page=Search&type=model" method="post">
                            <ul class="navbar-nav ml-auto">
                                <li> <input class="form-control" type="text" name="search" placeholder="Search anythings..."></li>
                                <li style="padding-left: 30px;">   <input type="submit" value="search" class="btn btn-primary"></li>
                            </ul>
                        </form>

                    </li>
                    <li class="nav-item" style="padding-left: 20px;">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#SignModal">
                            login
                        </button>
                    </li>

                </ul>
            </div>  
        </nav>
        <% for (int i = 0; i < 6; i++) { %>

        <% }%>


        <h1>login successfull!</h1>
        <div class="form-group">
            <form method="post" action="fc/?page=ImageUpload&type=model" enctype="multipart/form-data">
                <input type="file" name="file"/>
                <input type="submit" value="upload"/>
            </form>

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
