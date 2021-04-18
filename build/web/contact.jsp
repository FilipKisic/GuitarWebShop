<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://gibson.com" prefix="gibson" %>
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
        <gibson:NavBar active="contact" />
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
        <gibson:FooterTagHandler active="standard" />
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
