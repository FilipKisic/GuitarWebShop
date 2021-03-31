package com.gibson.controllers;

import com.gibson.model.Item;
import com.gibson.services.ItemService;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ESController", urlPatterns = {"/showes"})
public class ESController extends HttpServlet {

    private final ItemService itemService = new ItemService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Item> guitars = itemService.selectByCategory(3);
        HttpSession session = request.getSession();
        session.setAttribute("guitars", guitars);
        response.sendRedirect("es.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
