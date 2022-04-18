package gov.iti.jets.shoppy.presentation.controllers;

import gov.iti.jets.shoppy.service.DomainFacade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SearchProductServlet" , value = "/search")

public class SearchServletController extends HttpServlet{
    private final DomainFacade domainFacade = DomainFacade.getInstance();
    int pageNumber = 1;
    String value = "";
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/customer/home.jsp");
        value = req.getParameter("key");

        try {
            req.setAttribute("helper", domainFacade.searchForProducts(value));
            rd.include(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }


    }
}

