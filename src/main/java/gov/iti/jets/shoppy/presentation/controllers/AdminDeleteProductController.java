package gov.iti.jets.shoppy.presentation.controllers;

import gov.iti.jets.shoppy.service.DomainFacade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminDeleteProductController" , value = "/delete")
public class AdminDeleteProductController extends HttpServlet {
    private final DomainFacade domainFacade = DomainFacade.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("id"));
        if(domainFacade.deleteProduct(Integer.parseInt(req.getParameter("id")))){
            resp.sendRedirect("show-all-products");
        }else{
            req.setAttribute("error", "can't delete product");
            req.getRequestDispatcher("WEB-INF/views/admin/products.jsp").forward(req, resp);
        }
    }
}
