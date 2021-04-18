<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://gibson.com" prefix="gibson" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Your History</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="res/css/style.css">
        <link rel="stylesheet" href="res/css/font.css">
        <link rel="stylesheet" href="res/css/history.css">
        <link rel="icon" type="image/png" href="res/icons/favicon-16x16.png" />
    </head>

    <body>
        <gibson:NavBar active="guitar" />
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <h1 class="custom-title">Your shopping history</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <div class="cart-content">
                        <div class="cart-item-image">
                            <img src="res/images/Slash.png" alt="Item picture" class="img-fluid cart-image">
                        </div>
                        <div class="cart-item-details">
                            <div class="cart-item-title">
                                <p>Slash Gibson Les Paul Gold Top</p>
                            </div>
                            <div class="cart-item-price">
                                <p>$ 2,999.00</p>
                            </div>
                        </div>
                        <div class="cart-content-right">
                            <div class="cart-quantity">
                                <p class="quantity-text">Quantity:</p>
                                <p class="quantity-number">1</p>
                            </div>
                            <p class="purchase-details">Purchase date: 01.02.2021</p>
                            <p class="purchase-details">Payment method: Paypal</p>
                        </div>
                    </div>
                    <div class="cart-content">
                        <div class="cart-item-image">
                            <img src="res/images/1959Standard.png" alt="Item picture" class="img-fluid cart-image">
                        </div>
                        <div class="cart-item-details">
                            <div class="cart-item-title">
                                <p>1958 Les Paul Standard Reissue</p>
                            </div>
                            <div class="cart-item-price">
                                <p>$ 4,999.00</p>
                            </div>
                        </div>
                        <div class="cart-content-right">
                            <div class="cart-quantity">
                                <p class="quantity-text">Quantity:</p>
                                <p class="quantity-number">1</p>
                            </div>
                            <p class="purchase-details">Purchase date: 04.04.2021</p>
                            <p class="purchase-details">Payment method: Cash</p>
                        </div>
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