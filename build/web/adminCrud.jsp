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
        <link rel="stylesheet" href="res/css/admin.css">
        <link rel="stylesheet" href="res/css/crud.css">
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
                            <a class="dropdown-item custom-item" href="showlespaul">Les Paul</a>
                            <a class="dropdown-item custom-item" href="showsg">SG</a>
                            <a class="dropdown-item custom-item" href="showes">ES</a>
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
                <% }%>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="dropdown">
                        <button class="btn btn-lg dropdown-toggle select-button" type="button" id="dropdownMenu2"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Select product
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                            <button class="dropdown-item" type="button">Les Paul Slash</button>
                            <button class="dropdown-item" type="button">Les Paul Standard</button>
                            <button class="dropdown-item" type="button">ES-335</button>
                            <button class="dropdown-item" type="button">BB King ES Custom</button>
                            <button class="dropdown-item" type="button">SG Angus Young Custom</button>
                        </div>
                    </div>
                    <form>
                        <div class="form-group">
                            <label for="itemName">Guitar model name</label>
                            <input type="text" class="form-control form-control-lg custom-form" id="itemName"
                                   placeholder="1969 Les Paul Standard Reissue">
                        </div>
                        <div class="form-group">
                            <label for="itemDescription">Description</label>
                            <textarea class="form-control custom-form" id="itemDescription" rows="5"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="itemName">Price</label>
                            <input type="text" class="form-control form-control-lg custom-form" id="itemName"
                                   placeholder="4199">
                        </div>
                        <div class="form-group">
                            <label for="itemCategory">Category</label>
                            <select class="form-control form-control-lg custom-form" id="itemCategory">
                                <option>Les Paul</option>
                                <option>SG</option>
                                <option>ES</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="file-label" for="img">Select image:</label>
                            <input type="file" id="img" name="img" accept="image/*">
                            <input class="btn submit-button" type="submit">
                        </div>
                        <div class="row">
                            <div class="col">
                                <button type="submit" class="btn btn-warning custom-button">Create</button>
                            </div>
                            <div class="col">
                                <button type="submit" class="btn btn-warning custom-button">Update</button>
                            </div>
                            <div class="col">
                                <button type="submit" class="btn btn-warning custom-button">Delete</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <gibson:FooterTagHandler/>
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
