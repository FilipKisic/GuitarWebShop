package com.gibson.controllers;

import com.gibson.model.ConnectionInfo;
import com.gibson.model.User;
import com.gibson.services.InfoService;
import com.gibson.services.UserService;
import com.gibson.utils.ConnectionUtils;
import com.gibson.utils.Constants;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Filip Kisic
 */
public class LoginController extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("emailInput");
        String username = email.substring(0, email.indexOf("@"));
        Optional<User> loggedUser = userService.authenticate(request.getParameter("emailInput"), request.getParameter("passwordInput"));
        HttpSession session = request.getSession();
        if (!loggedUser.isPresent()) {
            response.sendRedirect("login.jsp");
        } else {
            session.setAttribute(Constants.USERNAME, username);
            session.setAttribute(Constants.USER, loggedUser.get());
            ConnectionUtils.createConnectionInfo(request, username);
            if (loggedUser.get().isAdmin()) {
                response.sendRedirect("allHistory");
            } else {
                response.sendRedirect("index.jsp");
            }
        }
    }
}
/*
TODO

PAYPAL

QUANTITY

DONE
 */
