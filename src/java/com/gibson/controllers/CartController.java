package com.gibson.controllers;

import com.gibson.model.Item;
import com.gibson.services.ItemService;
import com.gibson.utils.Constants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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
        String itemId = request.getParameter(Constants.ITEM_ID);
        String doRemove = request.getParameter(Constants.REMOVE);

        Map<Item, Integer> cartItems = (Map<Item, Integer>) session.getAttribute(Constants.CART);
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }

        if ("true".equals(doRemove)) {
            Item itemToDelete = new Item();
            Set<Item> items = cartItems.keySet();
            for (Iterator<Item> it = items.iterator(); it.hasNext();) {
                Item item = it.next();
                if(item.getId() == Integer.parseInt(itemId)){
                    itemToDelete = item;
                    break;
                }
            }
            cartItems.remove(itemToDelete);
            System.out.println("################################ GOT HERE ID: " + itemId);
        } else {
            if (!"0".equals(itemId)) {
                Optional<Item> item = itemService.findById(Integer.parseInt(itemId));
                if (item.isPresent() && !cartItems.containsKey(item)) {
                    cartItems.put(item.get(), 1); //TODO Should replace 1 with real quantity value
                }
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
