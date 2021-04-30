<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.gibson.utils.Constants"%>
<%@page import="java.util.List"%>
<%@page import="com.gibson.model.AdminHistory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@taglib uri="http://gibson.com" prefix="gibson" %>
<% List<AdminHistory> history = (List<AdminHistory>) session.getAttribute(Constants.ADMIN_HISTORY);%>
<% DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>All History</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="res/css/admin.css">
        <link rel="stylesheet" href="res/css/history.css">
        <link rel="stylesheet" href="res/css/font.css">
        <link rel="icon" type="image/png" href="res/icons/favicon-16x16.png" />
    </head>

    <body>
        <gibson:NavBar active="history" />
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <form action="allHistory" method="post">
                        <div class="filter-part">
                            <h1 class="custom-title">All history</h1>
                            <input type="text" name="email-filter" class="form-control custom-input" placeholder="Email filter">
                            <input type="date" name="dateFrom-filter" class="form-control custom-input" placeholder="Date from">
                            <input type="date" name="dateTo-filter" class="form-control custom-input" placeholder="Date to">
                            <input type="submit" value="Filter" class="btn btn-warning custom-button custom-submit">
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <% for (AdminHistory item : history) {%>
                    <div class="cart-content">
                        <div class="cart-item-details">
                            <div class="cart-item-title">
                                <p><%= item.getItemName()%></p>
                            </div>
                            <div class="cart-item-price">
                                <p><%="$" + String.format("%.2f", item.getPrice())%></p>
                            </div>
                        </div>
                        <div class="cart-content-right">
                            <div class="cart-quantity">
                                <p class="quantity-text">Quantity:</p>
                                <p class="quantity-number"><%= item.getQuantity().toString()%></p>
                            </div>
                            <p class="purchase-details">Purchase date: <%= item.getDateOfPurchase().format(formatter)%></p>
                            <p class="purchase-details">Payment method: <%= item.getPaymentMethod()%></p>
                        </div>
                    </div>
                    <% }%>
                </div>
            </div>
        </div>
        <gibson:FooterTagHandler active="standard"/>
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
