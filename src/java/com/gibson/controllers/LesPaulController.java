package com.gibson.controllers;

import com.gibson.model.Item;
import com.gibson.services.ItemService;
import com.gibson.utils.Constants;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Filip Kisic
 */
public class LesPaulController extends HttpServlet {
    
    private final ItemService itemService = new ItemService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Item> guitars = itemService.selectByCategory(1);
        HttpSession session = request.getSession();
        session.setAttribute(Constants.GUITAR_LIST, guitars);
        response.sendRedirect("lespauls.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}