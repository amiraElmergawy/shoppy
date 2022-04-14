package gov.iti.jets.shoppy.presentation.controllers;

import gov.iti.jets.shoppy.presentation.helpers.ShoppingCartViewHelper;
import gov.iti.jets.shoppy.service.DomainFacade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShoppingCartServletController" , value = "/shopping-cart")
public class ShoppingCartServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/customer/product-cart.jsp");
        try {
            Integer id = Integer.parseInt(req.getSession(false).getAttribute("userId")+"");
            ShoppingCartViewHelper shoppingCartViewHelper = DomainFacade.getInstance().getShoppingCart(id);
            if(shoppingCartViewHelper.getOrderDto() != null)
                req.getSession().setAttribute("cart", shoppingCartViewHelper.getOrderDto());
            rd.include(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}