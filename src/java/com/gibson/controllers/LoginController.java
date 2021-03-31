package com.gibson.controllers;

import com.gibson.model.User;
import com.gibson.services.UserService;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Filip Kisic
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    
    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("emailInput");
        String username = email.substring(0, email.indexOf("@"));
        Optional<User> loggedUser = userService.authenticate(request.getParameter("emailInput"), request.getParameter("passwordInput"));
        HttpSession session = request.getSession();
        if(!loggedUser.isPresent()){
            response.sendRedirect("login.jsp");
        } else {
            session.setAttribute("username", username);
            session.setAttribute("user", loggedUser);
            response.sendRedirect("index.jsp");
        }
    }
}
