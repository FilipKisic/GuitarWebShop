package com.gibson.controllers;

import com.gibson.model.Item;
import com.gibson.services.ItemService;
import com.gibson.utils.Constants;
import com.gibson.utils.ImageUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Filip Kisic
 */
@MultipartConfig
public class CrudController extends HttpServlet {

    private final ItemService itemService = new ItemService();
    private List<Item> items;
    private String guitarId;
    private String guitarName;
    private String guitarDescription;
    private String guitarPrice;
    private String guitarCategory;
    private Part guitarImage;
    private String button;
    private Optional<Item> selectedItem;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        items = itemService.findAll();
        session.setAttribute(Constants.ITEMS, items);
        response.sendRedirect("adminCrud.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getData(request);
        HttpSession session = request.getSession();

        if (guitarId != null) {
            selectedItem = itemService.findById(Integer.parseInt(guitarId));
            session.setAttribute(Constants.GUITAR, selectedItem.get());
            response.sendRedirect("adminCrud.jsp");
        } else {
            if (button.equals("create")) {
                if (isValid()) {
                    InputStream fileContent = guitarImage.getInputStream();
                    if (fileContent != null) {
                        byte[] image = ImageUtils.convertInputStreamToByteArray(fileContent);
                        itemService.create(new Item(guitarName, guitarDescription, Double.parseDouble(guitarPrice), image, Integer.parseInt(guitarCategory)));
                    }
                }
            }
            if (button.equals("update")) {
                if (selectedItem.isPresent() && isValid()) {
                    InputStream fileContent = guitarImage.getInputStream();
                    if (fileContent != null) {
                        byte[] image = ImageUtils.convertInputStreamToByteArray(fileContent);
                        itemService.update(new Item(selectedItem.get().getId(), guitarName, guitarDescription, Double.parseDouble(guitarPrice), image, Integer.parseInt(guitarCategory)));
                    }
                }
            }
            if (button.equals("delete")) {
                if (selectedItem.isPresent()) {
                    itemService.deleteById(selectedItem.get().getId());
                }
            }
            response.sendRedirect("crud");
        }
    }

    private void getData(HttpServletRequest request) throws IOException, ServletException {
        guitarId = request.getParameter("guitarDD");
        guitarName = request.getParameter("guitarName");
        guitarDescription = request.getParameter("guitarDescription");
        guitarPrice = request.getParameter("guitarPrice");
        guitarCategory = request.getParameter("guitarCategory");
        button = request.getParameter("button_clicked");
        guitarImage = request.getPart("guitarImage");
    }

    private boolean isValid() {
        boolean isOkay = true;
        if (guitarName.equals("")) {
            isOkay = false;
        }
        if (guitarDescription.equals("")) {
            isOkay = false;
        }
        if (guitarPrice.equals("")) {
            isOkay = false;
        }
        if (guitarCategory.equals("")) {
            isOkay = false;
        }
        return isOkay;
    }
}
