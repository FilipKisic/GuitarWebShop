package com.gibson.controllers;

import com.gibson.model.Item;
import com.gibson.services.ItemService;
import com.gibson.utils.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class CartController extends HttpServlet {

    private final ItemService itemService = new ItemService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String itemId = request.getParameter("itemId");
        String doRemove = request.getParameter("remove");

        List<Item> cartItems = (List<Item>) session.getAttribute(Constants.CART);
        if (cartItems == null)
            cartItems = new ArrayList<>();

        if ("true".equals(doRemove)) {
            cartItems.remove(Integer.parseInt(itemId));
        } else {
            Optional<Item> item = itemService.findById(Integer.parseInt(itemId));
            if (item.isPresent() && !cartItems.contains(item)) {
                cartItems.add(item.get());
            }
        }

        session.setAttribute(Constants.CART, cartItems);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cart.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
