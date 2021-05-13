package com.gibson.controllers;

import com.gibson.model.Bill;
import com.gibson.model.Item;
import com.gibson.model.User;
import com.gibson.services.BillService;
import com.gibson.utils.Constants;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Filip Kisic
 */
public class PaymentController extends HttpServlet {

    private final BillService billService = new BillService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Double totalPrice = 0.0;

        Map<Item, Integer> billItems = (Map<Item, Integer>) session.getAttribute(Constants.CART);

        for (Item item : billItems.keySet()) {
            totalPrice += item.getPrice() * billItems.get(item);
        }

        User loggedInUser = (User) session.getAttribute(Constants.USER);
        if (loggedInUser == null) {
            response.sendRedirect("login.jsp");
        } else {
            Bill bill = Bill.builder()
                    .userId(loggedInUser.getId())
                    .dateOfPurchase(LocalDateTime.now())
                    .totalPrice(totalPrice)
                    .paymentMethod(Constants.CASH_PAYMENT)
                    .build();

            bill = billService.create(bill).get();
            for (Item item : billItems.keySet()) {
                billService.addItemToBill(bill.getId(), item.getId(), billItems.get(item));
            }
            billItems.clear();
            response.sendRedirect("thankyou.jsp");
      }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
