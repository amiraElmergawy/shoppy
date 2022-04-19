package gov.iti.jets.shoppy.presentation.controllers;

import gov.iti.jets.shoppy.presentation.helpers.ViewProductHelper;
import gov.iti.jets.shoppy.service.DomainFacade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ProductDetailsServletController" , value = "/product-details")
public class ProductDetailsServletController extends HttpServlet {
    private final DomainFacade domainFacade = DomainFacade.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/customer/product-detail.jsp");
        try {
            req.setAttribute("productDto", domainFacade.getProductById(Integer.parseInt(req.getParameter("productID"))).getProductDto());
            req.setAttribute("error",req.getParameter("error"));
            rd.include(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}