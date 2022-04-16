package gov.iti.jets.shoppy.presentation.controllers;

import gov.iti.jets.shoppy.presentation.helpers.ShoppingCartViewHelper;
import gov.iti.jets.shoppy.service.DomainFacade;
import gov.iti.jets.shoppy.service.dtos.OrderDto;
import gov.iti.jets.shoppy.service.interfaces.ShoppingCartService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "AddProductToCartServletController", value = "/add-to-cart")
public class AddProductToCartServletController extends HttpServlet {
    private final DomainFacade facade = DomainFacade.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer productId = Integer.parseInt(req.getParameter("productId"));
        HttpSession httpSession = req.getSession(false);
        Integer customerId = Integer.parseInt(httpSession.getAttribute("userId")+"");
        OrderDto sessionCart = (OrderDto) httpSession.getAttribute("cart");
        ShoppingCartViewHelper shoppingCartViewHelper;
        if(sessionCart == null) {
            shoppingCartViewHelper = facade.addProductToCart(customerId, productId);
        }else {
            shoppingCartViewHelper = facade.addProductToCart(sessionCart, productId);
        }
        if(shoppingCartViewHelper.getError() == null) {
            httpSession.setAttribute("cart", shoppingCartViewHelper.getOrderDto());
            /**
             * redirect to product page with confirmation msg
             */
            resp.sendRedirect("shopping-cart");

        }
        else {
            resp.sendRedirect("product-details?productID="+productId+"&error=true");
        }
    }
}
