package com.gibson.controllers;

import com.gibson.model.AdminHistory;
import com.gibson.services.HistoryService;
import com.gibson.utils.Constants;
import java.io.IOException;
import java.time.LocalDate;
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
public class AllHistory extends HttpServlet {

    private final HistoryService historyService = new HistoryService();
    private String dateTo;
    private String dateFrom;
    private String email;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<AdminHistory> history = historyService.findAll();
        session.setAttribute(Constants.ADMIN_HISTORY, history);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminHistory.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        email = request.getParameter("email-filter");
        dateFrom = request.getParameter("dateFrom-filter");
        dateTo = request.getParameter("dateTo-filter");
        HttpSession session = request.getSession();

        if (!"".equals(email) && !"".equals(dateFrom) && !"".equals(dateTo)) {
            LocalDate dateStart = LocalDate.parse(dateFrom);
            LocalDate dateEnd = LocalDate.parse(dateTo);
            List<AdminHistory> history = historyService.findAllByEmailAndDate(email, dateStart.atStartOfDay(), dateEnd.atStartOfDay());
            session.setAttribute(Constants.ADMIN_HISTORY, history);
            clearProperties();

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminHistory.jsp");
            dispatcher.forward(request, response);
        } else if ("".equals(email) && !"".equals(dateFrom) && !"".equals(dateTo)) {
            LocalDate dateStart = LocalDate.parse(dateFrom);
            LocalDate dateEnd = LocalDate.parse(dateTo);
            List<AdminHistory> history = historyService.findAllByDate(dateStart.atStartOfDay(), dateEnd.atStartOfDay());
            session.setAttribute(Constants.ADMIN_HISTORY, history);
            clearProperties();

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminHistory.jsp");
            dispatcher.forward(request, response);
        } else if (!"".equals(email)) {
            List<AdminHistory> history = historyService.findAllByEmail(email);
            session.setAttribute(Constants.ADMIN_HISTORY, history);
            clearProperties();

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminHistory.jsp");
            dispatcher.forward(request, response);
        } else {
            List<AdminHistory> history = historyService.findAll();
            session.setAttribute(Constants.ADMIN_HISTORY, history);
            clearProperties();

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/adminHistory.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void clearProperties() {
        email = "";
        dateFrom = "";
        dateTo = "";
    }
}
