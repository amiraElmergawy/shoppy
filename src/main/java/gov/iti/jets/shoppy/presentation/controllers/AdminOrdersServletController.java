package gov.iti.jets.shoppy.presentation.controllers;

import gov.iti.jets.shoppy.service.DomainFacade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminOrdersServletController" , value = "/show-all-orders")
public class AdminOrdersServletController extends HttpServlet {
    private final DomainFacade domainFacade = DomainFacade.getInstance();
    int pageNumber = 1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/admin/orders.jsp");
        if(req.getParameter("pageNum") != null)
            pageNumber = Integer.parseInt(req.getParameter("pageNum"));
        try {
            System.out.println(domainFacade.retrieveOrders(pageNumber).getOrdersDtoList().get(0));
            System.out.println(domainFacade.retrieveOrders(pageNumber).getErrorMessage());
            req.setAttribute("orders", domainFacade.retrieveOrders(pageNumber));
            rd.include(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
