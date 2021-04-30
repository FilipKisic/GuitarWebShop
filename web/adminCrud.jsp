<%@page import="com.gibson.model.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.gibson.model.Item"%>
<%@page import="com.gibson.utils.Constants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://gibson.com" prefix="gibson" %>
<%@page session="true" %>
<% List<Item> items = (List<Item>) session.getAttribute(Constants.ITEMS);%>
<% Item selectedItem = (Item) session.getAttribute(Constants.GUITAR); %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CRUD</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="res/css/admin.css">
        <link rel="stylesheet" href="res/css/crud.css">
        <link rel="stylesheet" href="res/css/font.css">
        <link rel="icon" type="image/png" href="res/icons/favicon-16x16.png" />
    </head>

    <body>
        <gibson:NavBar active="adminCrud" />
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="dropdown">
                        <form action="crud" method="post" enctype="multipart/form-data">
                            <select name="guitarDD" class="btn btn-lg dropdown-toggle select-button">
                                <% for (Item item : items) {%>
                                <option value="<%=item.getId()%>" class="dropdown-item"
                                        <% if (selectedItem != null && item.getId() == selectedItem.getId()) { %> selected <% }%>>
                                    <%= "#" + item.getId() + " " + item.getName()%></option>
                                    <% }%>
                            </select>
                            <input type="submit" class="btn btn-warning custom-button"> 
                        </form>
                    </div>
                    <form action="crud" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="itemName">Guitar model name</label>
                            <input type="text" name="guitarName" class="form-control form-control-lg custom-form" id="itemName"
                                   placeholder="1969 Les Paul Standard Reissue" 
                                   value="<% if (selectedItem != null) {%><%= selectedItem.getName()%><% }%>">
                        </div>
                        <div class="form-group">
                            <label for="itemDescription">Description</label>
                            <textarea name="guitarDescription" class="form-control custom-form" id="itemDescription" rows="5">
                                <% if (selectedItem != null) {%><%= selectedItem.getDescription().trim()%><% }%>
                            </textarea>
                        </div>
                        <div class="form-group">
                            <label for="itemPrice">Price</label>
                            <input type="text" name="guitarPrice" class="form-control form-control-lg custom-form" id="itemPrice"
                                   placeholder="4199" value="<% if (selectedItem != null) {%><%=selectedItem.getPrice()%><% }%>">
                        </div>
                        <div class="form-group">
                            <label for="itemCategory">Category</label>
                            <select name="guitarCategory" class="form-control form-control-lg custom-form" id="itemCategory">
                                <% for (Category category : Category.values()) {%>
                                <option value="<%=category.getId()%>" class="dropdown-item"
                                        <% if (selectedItem != null && selectedItem.getCategoryId() == category.getId()) {%> selected <% }%>
                                        ><%= category.name()%></option>
                                <% }%>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="file-label" for="img">Select image:</label>
                            <input type="file" id="img" name="guitarImage" accept="image/*">
                        </div>
                        <div class="row">
                            <div class="col">
                                <button type="submit" name="button_clicked" value="create" class="btn btn-warning custom-button">Create</button>
                            </div>
                            <div class="col">
                                <button type="submit" name="button_clicked" value="update" class="btn btn-warning custom-button">Update</button>
                            </div>
                            <div class="col">
                                <button type="submit" name="button_clicked" value="delete" class="btn btn-warning custom-button">Delete</button>
                            </div>
                        </div>
                    </form>
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
