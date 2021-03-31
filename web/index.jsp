<%@page import="com.gibson.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<% User user = (User) (session.getAttribute("user")); %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gibson Home Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="res/css/style.css">
        <link rel="stylesheet" href="res/css/font.css">
        <link rel="icon" type="image/png" href="res/icons/favicon-16x16.png" />
    </head>

    <body>
        <nav class="navbar sticky-top navbar-expand-lg navbar-custom">
            <a class="navbar-brand" href="#">
                <img src="res/images/gibson_logo.png" width="120">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Guitars
                        </a>
                        <div class="dropdown-menu custom-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item custom-item" href="lespauls.jsp">Les Paul</a>
                            <a class="dropdown-item custom-item" href="sg.jsp">SG</a>
                            <a class="dropdown-item custom-item" href="#">ES</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contact.jsp">Contact</a>
                    </li>
                </ul>
                <%if (session.getAttribute("username") == null) {%>
                <a class="nav-link" href="login.jsp">Login</a>
                <%} else {%>
                <a class="nav-link" href="#"><%= session.getAttribute("username")%></a>
                <% } %>
            </div>
        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6 col-sm-12">
                    <h1 class="header-title">Gibson Les Paul Standard 2015</h1>
                    <p class="header-description">The most versatile Standard yet, with a superbly comfortable asymmetrical
                        neck profile and easy–bending compound radius 'board.</p>
                    <button type="button" class="btn btn-warning header-button">More info</button>
                </div>
                <div class="col-lg-6 col-sm-12">
                    <img src="res/images/gibson_2015_header_crop.png" class="img-fluid header-image">
                </div>
            </div>
            <div class="row">
                <div class="col-12 carousel-custom">
                    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="d-block w-100" src="res/images/slash_collection_header.jpg" alt="First slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block w-100" src="res/images/gibson_acoustic_header.jpg" alt="Second slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block w-100" src="res/images/aviator_nation_header.jpg" alt="Third slide">
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <footer>
            <div class="row my-5 justify-content-center py-5 footer-row">
                <div class="col-11">
                    <div class="row ">
                        <div class="col-xl-8 col-md-4 col-sm-4 col-12 my-auto mx-auto a">
                            <img src="res/images/gibson_logo.png" class="img-fluid" width="250">
                        </div>
                        <div class="col-xl-2 col-md-4 col-sm-4 col-12">
                            <h6 class="mb-3 mb-lg-4 bold-text "><b>MENU</b></h6>
                            <ul class="list-unstyled">
                                <li><a href="index.jsp" class="custom-link">Home</a></li>
                                <li><a href="lespauls.jsp" class="custom-link">Guitars</a></li>
                                <li><a href="contact.jsp" class="custom-link">Contact</a></li>
                            </ul>
                        </div>
                        <div class="col-xl-2 col-md-4 col-sm-4 col-12">
                            <h6 class="mb-3 mb-lg-4 text-muted bold-text mt-sm-0 mt-5"><b>ADDRESS</b></h6>
                            <p class="mb-1">209 10th Ave S, Ste 460</p>
                            <p>Nashville, Tennessee, USA</p>
                        </div>
                    </div>
                    <div class="row ">
                        <div class="col-xl-8 col-md-4 col-sm-4 col-auto my-md-0 mt-5 order-sm-1 order-3 align-self-end">
                            <p class="social text-muted mb-0 pb-0 bold-text">
                                <a href="https://www.facebook.com/Gibson/" class="mx-2"><i
                                        class="fa fa-facebook custom-icon" aria-hidden="true"></i></a>
                                <a href="https://www.youtube.com/user/GibsonGuitarCorp" class="mx-2"><i
                                        class="fa fa-youtube custom-icon" aria-hidden="true"></i></a>
                                <a href="https://twitter.com/gibsonguitar" class="mx-2"><i class="fa fa-twitter custom-icon"
                                                                                           aria-hidden="true"></i></a>
                                <a href="https://www.instagram.com/gibsonguitar/" class="mx-2"><i
                                        class="fa fa-instagram custom-icon" aria-hidden="true"></i></a>
                            </p>
                            <small class="rights"><span>&#174;</span> Gibson All Rights Reserved.</small>
                        </div>
                        <div class="col-xl-2 col-md-4 col-sm-4 col-auto order-1 align-self-end ">
                            <h6 class="mt-55 mt-2 text-muted bold-text"><b>Email</b></h6>
                            <small><span><i class="fa fa-envelope" aria-hidden="true"></i></span> info@gibson.com</small>
                        </div>
                        <div class="col-xl-2 col-md-4 col-sm-4 col-auto order-2 align-self-end mt-3 ">
                            <h6 class="text-muted bold-text"><b>Questions, comments?</b></h6>
                            <small>We're all ears.</small>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/5c499144e7.js" crossorigin="anonymous"></script>
    </body>

</html>
