package com.gibson.controllers;

import com.gibson.model.History;
import com.gibson.model.User;
import com.gibson.services.UserService;
import com.gibson.utils.Constants;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Filip Kisic
 */
public class HistoryController extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loggedInUser = (User) session.getAttribute(Constants.USER);
        if (loggedInUser != null) {
            List<History> history = userService.getUserPurchaseHistory(loggedInUser.getId());
            session.setAttribute(Constants.HISTORY, history);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/shoppingHistory.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
