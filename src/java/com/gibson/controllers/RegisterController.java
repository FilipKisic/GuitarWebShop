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
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("registerEmailInput");
        String password = request.getParameter("registerPasswordInput");
        String repeatedPassword = request.getParameter("repeatedPasswordInput");
        String username = email.substring(0, email.indexOf("@"));
        HttpSession session = request.getSession();
        if (userService.findAll().stream().filter(user -> user.getEmail().equals(email)).findFirst().isPresent()) {
            System.out.println("User already exists");
        } else {
            if (password.equals(repeatedPassword)) {
                Optional<User> loggedUser = userService.create(new User(email, password, false));
                session.setAttribute("username", username);
                session.setAttribute("user", loggedUser);
                response.sendRedirect("index.jsp");
            }
        }
    }
}
