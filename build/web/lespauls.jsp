<%@page import="com.gibson.utils.Constants"%>
<%@page import="com.gibson.utils.ImageUtils"%>
<%@page import="com.gibson.model.Item"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://gibson.com" prefix="gibson" %>
<%@page session="true" %>
<% List<Item> items = (List<Item>) (session.getAttribute(Constants.GUITAR_LIST));%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Les Paul Collection</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="res/css/style.css">
        <link rel="stylesheet" href="res/css/guitars.css">
        <link rel="stylesheet" href="res/css/font.css">
        <link rel="icon" type="image/png" href="res/icons/favicon-16x16.png" />
    </head>

    <body>
        <gibson:NavBar active="guitar" />
        <div class="container">
            <div clas="row">
                <div class="col-lg-12 col-sm-12">
                    <div class="card-deck custom-deck">
                        <% for (int row = 0; row < items.size(); row++) {
                                if (row != 0 && row % 3 == 0) {
                        %>
                    </div>
                    <div class="card-deck custom-deck">
                        <% }%>
                        <div class="card custom-card" style="width: 18rem;">
                            <img class="card-img-top" src="data:image/jpg;base64,<%= ImageUtils.convertBytesToBase64Image(items.get(row).getImage())%>" alt="Junior">
                            <div class="card-body">
                                <h4 class="card-title custom-card-title"><%= items.get(row).getName()%></h4>
                                <p class="card-text text-right custom-card-text"><%="$" + String.format("%.2f", items.get(row).getPrice())%></p>
                                <a href="details/?id=<%=items.get(row).getId()%>" class="btn btn-warning custom-button">Show details</a>
                            </div>
                        </div>
                        <% if (row == items.size() - 1) {%></div>
                        <% }
                            }%>
                </div>
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
