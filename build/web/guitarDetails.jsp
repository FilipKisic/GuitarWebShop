<%@page import="com.gibson.utils.Constants"%>
<%@page import="com.gibson.controllers.DetailsController"%>
<%@page import="com.gibson.utils.ImageUtils"%>
<%@page import="com.gibson.model.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@taglib uri="http://gibson.com" prefix="gibson" %>
<% Item item = (Item) session.getAttribute(Constants.GUITAR);%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Details</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="../res/css/style.css">
        <link rel="stylesheet" href="../res/css/details.css">
        <link rel="stylesheet" href="../res/css/font.css">
        <link rel="icon" type="image/png" href="../res/icons/favicon-16x16.png" />
    </head>

    <body>
        <gibson:NavBar active="details" />
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-8 col-md-12 col-sm-12">
                    <h1 class="guitar-title"><%= item.getName()%></h1>
                    <p class="guitar-description"><%= item.getDescription()%></p>
                    <h1 class="guitar-price"><%="$" + String.format("%.2f", item.getPrice())%></h1>
                    <a href="../cart/?itemId=<%=item.getId()%>" class="btn btn-warning custom-button">Add to cart</a>
                </div>
                <div class="col-lg-4 col-md-12 col-sm-12">
                    <img src="data:image/jpg;base64,<%= ImageUtils.convertBytesToBase64Image(item.getImage())%>" class="img-fluid custom-image" alt="">
                </div>
            </div>
        </div>
        <gibson:FooterTagHandler active="oneIncrement" />
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
