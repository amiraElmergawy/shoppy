package gov.iti.jets.shoppy.presentation.controllers;

import gov.iti.jets.shoppy.service.DomainFacade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminCustomersServletController" , value = "/show-all-customers")
public class AdminCustomersServletController extends HttpServlet {
    private final DomainFacade domainFacade = DomainFacade.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNumber = 1;
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/admin/customers.jsp");
        if(req.getParameter("pageNum") != null)
            pageNumber = Integer.parseInt(req.getParameter("pageNum"));
        try {
            System.out.println(domainFacade.retrieveCustomers(pageNumber).getCustomerDtoList().get(0));
            System.out.println(domainFacade.retrieveCustomers(pageNumber).getErrorMessage());
            req.setAttribute("customers", domainFacade.retrieveCustomers(pageNumber));
            rd.include(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
