package com.gibson.controllers;

import com.gibson.model.Item;
import com.gibson.services.ItemService;
import com.gibson.utils.Constants;
import java.io.IOException;
import java.util.Optional;
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
public class DetailsController extends HttpServlet {

    private final ItemService itemService = new ItemService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        if (id != null) {
            Optional<Item> guitar = itemService.findById(Integer.parseInt(id));
            session.setAttribute(Constants.GUITAR, guitar.get());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/guitarDetails.jsp");
            dispatcher.forward(request, response);
        }
    }
}
