package gov.iti.jets.shoppy.presentation.controllers;

import gov.iti.jets.shoppy.service.DomainFacade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomePageServletController" , value = "/home")
public class HomePageServletController extends HttpServlet {
    private final DomainFacade domainFacade = DomainFacade.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/customer/home.jsp");
        int pageNumber = 1;
        if(req.getParameter("pageNum") != null)
            pageNumber = Integer.parseInt(req.getParameter("pageNum"));
        try {
                System.out.println(domainFacade.retrieveProducts(pageNumber));
                req.setAttribute("helper", domainFacade.retrieveProducts(pageNumber));
                rd.include(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}