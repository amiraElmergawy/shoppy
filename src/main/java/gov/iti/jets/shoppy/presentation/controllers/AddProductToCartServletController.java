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

@WebServlet(name = "AddProductToCartServletController", urlPatterns = "/add-to-cart")
public class AddProductToCartServletController extends HttpServlet {
    private final DomainFacade facade = DomainFacade.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer productId = Integer.parseInt(req.getParameter("productId"));
        HttpSession httpSession = req.getSession(false);
        Integer customerId = Integer.parseInt(httpSession.getAttribute("userId")+"");
        OrderDto orderDto = (OrderDto) httpSession.getAttribute("cart");
        ShoppingCartViewHelper shoppingCartViewHelper = new ShoppingCartViewHelper();

        if(orderDto == null)
            shoppingCartViewHelper = facade.initializeCustomerCart(customerId, productId);

        if(shoppingCartViewHelper.getError() == null)
            httpSession.setAttribute("cart", shoppingCartViewHelper.getOrderDto());
        else
            httpSession.setAttribute("error", shoppingCartViewHelper.getError());

        System.out.println(httpSession.getAttribute("cart"));

    }
}
