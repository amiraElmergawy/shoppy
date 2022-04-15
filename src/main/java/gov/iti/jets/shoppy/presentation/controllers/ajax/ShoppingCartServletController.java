package gov.iti.jets.shoppy.presentation.controllers.ajax;

import gov.iti.jets.shoppy.presentation.helpers.ShoppingCartViewHelper;
import gov.iti.jets.shoppy.service.DomainFacade;
import gov.iti.jets.shoppy.service.dtos.OrderDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ShoppingCartServletController" , value = "/shopping-cart")
public class ShoppingCartServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/customer/product-cart.jsp");
        try {
            Integer id = Integer.parseInt(req.getSession(false).getAttribute("userId")+"");
            ShoppingCartViewHelper shoppingCartViewHelper = DomainFacade.getInstance().loadShoppingCart(id);
            if(shoppingCartViewHelper.getOrderDto() != null)
                req.getSession().setAttribute("cart", shoppingCartViewHelper.getOrderDto());
            rd.include(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("test");
        System.out.println("rewlkssdkldsklsdmksdldskmldslkslkds");

        Integer productId = Integer.parseInt(req.getParameter("productId"));
        HttpSession httpSession = req.getSession(false);
        Integer customerId = Integer.parseInt(httpSession.getAttribute("userId")+"");
        OrderDto sessionCart = (OrderDto) httpSession.getAttribute("cart");
        ShoppingCartViewHelper shoppingCartViewHelper;
        if(sessionCart == null) {
            shoppingCartViewHelper = DomainFacade.getInstance().initializeCustomerCart(customerId, productId);
        }else {
            shoppingCartViewHelper = DomainFacade.getInstance().addProductToCart(sessionCart, productId);
        }
        if(shoppingCartViewHelper.getError() == null) {
            httpSession.setAttribute("cart", shoppingCartViewHelper.getOrderDto());
            resp.sendRedirect("shopping-cart");
        }
        else {
            resp.sendRedirect("product-details?productID="+productId+"&error=true");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var currentCustomerSession = req.getSession(false);
        int productId = Integer.parseInt(req.getParameter("productId"));
        String quantityAction = req.getParameter("quantityAction");
        if (quantityAction.equals("increase")){
            //check product q in db
            //if q > 0 => decrease it in db & increase it in shoppingCart
            if(!DomainFacade.getInstance().increaseProductInShoppingCart(productId)) {
                resp.getWriter().print("Product quantity can't be increased");
            } else {
                var orderDto = (OrderDto)currentCustomerSession.getAttribute("cart");
                orderDto.getOrderProducts().forEach(orderProductDto -> {
                    if (orderProductDto.getProduct().getId() == productId){
                        orderProductDto.setQuantity(orderProductDto.getQuantity()+1);
                    }
                });
                currentCustomerSession.setAttribute("cart", orderDto);
            }
        } else {
            //check product q in shopping cart => to handle q=0 case
            //if q > 0 => increase it in db & decrease it in shoppingCart
            var orderDto = (OrderDto)currentCustomerSession.getAttribute("cart");
            orderDto.getOrderProducts().forEach(orderProductDto -> {
                if ((orderProductDto.getProduct().getId() == productId) && (orderProductDto.getQuantity() > 0)){
                    orderProductDto.setQuantity(orderProductDto.getQuantity()-1);
                    DomainFacade.getInstance().decreaseProductInShoppingCart(productId);
                }
            });
            currentCustomerSession.setAttribute("cart", orderDto);
        }
        resp.getWriter().print("");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //increase product quantity in db by orderProduct quantity
        //remove orderProduct from order??
        var currentCustomerSession = req.getSession(false);
        int productId = Integer.parseInt(req.getParameter("productId"));
        var orderDto = (OrderDto)currentCustomerSession.getAttribute("cart");
        orderDto.getOrderProducts().forEach(orderProductDto -> {
            if (orderProductDto.getProduct().getId() == productId){
                DomainFacade.getInstance().deleteProductFromShoppingCart(productId, orderProductDto.getQuantity());
                orderDto.getOrderProducts().remove(orderProductDto);
            }
        });
        currentCustomerSession.setAttribute("cart", orderDto);
        resp.getWriter().print("");
    }
}