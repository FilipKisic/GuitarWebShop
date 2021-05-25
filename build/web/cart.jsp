<%@page import="com.gibson.controllers.PaymentController"%>
<%@page import="java.util.Map"%>
<%@page import="com.gibson.utils.ImageUtils"%>
<%@page import="com.gibson.utils.Constants"%>
<%@page import="com.gibson.model.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@taglib uri="http://gibson.com" prefix="gibson" %>
<% Map<Item, Integer> cartItems = (Map<Item, Integer>) session.getAttribute(Constants.CART);%>
<% double totalPrice = 0; %> 
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Your Cart</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="../res/css/style.css">
        <link rel="stylesheet" href="../res/css/font.css">
        <link rel="stylesheet" href="../res/css/cart.css">
        <link rel="icon" type="image/png" href="../res/icons/favicon-16x16.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    </head>

    <body>
        <gibson:NavBar active="cart" />
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <h1 class="custom-title">Content of your cart:</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <!<!-- Add form? -->
                    <% for (Item item : cartItems.keySet()) {%>
                    <div class="cart-content">
                        <div class="cart-item-image">
                            <img src="data:image/jpg;base64,<%= ImageUtils.convertBytesToBase64Image(item.getImage())%>" alt="Item picture" class="img-fluid cart-image">
                        </div>
                        <div class="cart-item-details">
                            <div class="cart-item-title">
                                <p><%= item.getName()%></p>
                            </div>
                            <div class="cart-item-price">
                                <p><%="$" + String.format("%.2f", item.getPrice())%></p>
                            </div>
                        </div>
                        <div class="cart-content-right">
                            <div class="cart-quantity">
                                <p class="quantity-text">Quantity:</p>
                                <input name="item-quantity" type="number" value="1" class="quantity-number">
                            </div>
                            <a href="../cart/?itemId=<%=item.getId()%>&remove=true" class="btn btn-warning btn-remove">Remove</a>
                        </div>
                    </div>
                    <% totalPrice += item.getPrice(); %>
                    <% }%>
                    <div class="total-price">
                        <h3 class="sum"><%= "Total: $" + totalPrice%></h3>
                        <div class="btn-paypal" id="paypal-button-container"></div>
                        <a href="../history" class="btn btn-warning btn-pay">History</a>
                        <a href="../payment" class="btn btn-warning btn-pay">Pay with Cash</a>
                    </div>
                </div>
            </div>
        </div>
        <gibson:FooterTagHandler active="oneIncrement"/>
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
        <script
            src="https://www.paypal.com/sdk/js?client-id=AeffotGCwrDZUngxcZ4Tpg_lyP8dq3yItYM0JcqibnkYQrOeYgZn9f6JTWG6YcmQFUa2PC_O6PcYKQJl">
        </script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
            paypal.Buttons({
                createOrder: function (data, actions) {
                    return actions.order.create({
                        purchase_units: [{
                                amount: {
                                    value: '<%=totalPrice%>'
                                }
                            }]
                    });
                },
                onApprove: function (data, actions) {
                    var params = {message: "success"};
                    $.post("${pageContext.request.contextPath}/payment", $.param(params), function (response) {
                        console.log('Success');
                    });
                    return actions.order.capture().then(function (details) {
                        alert('Transaction completed by ' + details.payer.name.given_name);
                    });
                }
            }).render("#paypal-button-container");
        </script>
    </body>

</html>
