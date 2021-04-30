package com.gibson.controllers;

import com.gibson.model.ConnectionInfo;
import com.gibson.utils.ConnectionUtils;
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
public class InfoController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<ConnectionInfo> connectionInfoList = ConnectionUtils.getConnectionInfoList();
        session.setAttribute(Constants.INFO, connectionInfoList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminInfo.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
