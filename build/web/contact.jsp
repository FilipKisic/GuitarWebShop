<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact us</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="res/css/style.css">
    <link rel="stylesheet" href="res/css/contact.css">
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
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
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
                <li class="nav-item active">
                    <a class="nav-link" href="contact.jsp">Contact</a>
                </li>
            </ul>
            <a class="nav-link" href="login.jsp">Login</a>
        </div>
    </nav>
    <div class="jumbotron custom-jumbotron">
        <div class="jumbotron-title">
            <h1>Do you have any questions?</h1>
            <h1>We are all ears.</h1>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6 col-md-12 col-sm-12 maps-section">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d206172.8583473706!2d-86.90760592499394!3d36.15558057365632!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x886468e0439ac505%3A0x8819dfe4dbc9fbaf!2sGibson%20USA!5e0!3m2!1shr!2shr!4v1615548379053!5m2!1shr!2shr" width="800" height="400" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
            </div>
            <div class="col-lg-6 col-md-12 col-sm-12">
                <h2 class="contact-info"><b>Our contact information</b></h2>
                <h2 class="contact-info">USA: 1-800-444-2766</h2>
                <h2 class="contact-info">Netherlands: 00+800-444-2766-1</h2>
                <h2 class="contact-info">Worldwide: +1-615-871-4500</h2>
                <h2 class="contact-info">Email: info@gibson.com</h2>
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
