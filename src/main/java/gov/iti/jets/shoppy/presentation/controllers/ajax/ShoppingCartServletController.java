package gov.iti.jets.shoppy.presentation.controllers.ajax;

import gov.iti.jets.shoppy.presentation.helpers.ShoppingCartViewHelper;
import gov.iti.jets.shoppy.service.DomainFacade;
import gov.iti.jets.shoppy.service.dtos.OrderDto;
import gov.iti.jets.shoppy.service.dtos.OrderProductDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
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
            rd.include(req,resp);
            Integer id = Integer.parseInt(req.getSession(false).getAttribute("userId")+"");
            OrderDto orderDto = (OrderDto) req.getSession().getAttribute("cart");
            if(orderDto == null)
                req.getSession().setAttribute("cart", DomainFacade.getInstance().loadShoppingCart(id).getOrderDto());

        } catch (ServletException e) {
            e.printStackTrace();
            System.out.println("current cart info "+req.getSession().getAttribute("cart"));
            req.getSession().setAttribute("msg","Your shopping cart is empty");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var currentCustomerSession = req.getSession(false);
        int productId = Integer.parseInt(req.getParameter("productId"));
        String quantityAction = req.getParameter("quantityAction");
        if (quantityAction != null && quantityAction.equals("increase")){
            //check product q in db
            //if q > 0 => decrease it in db & increase it in shoppingCart
            if(!DomainFacade.getInstance().increaseProductInShoppingCart(productId)) {
                resp.getWriter().print("this product out of stuck");
            } else {
                var orderDto = (OrderDto)currentCustomerSession.getAttribute("cart");
                orderDto.getOrderProducts().forEach(orderProductDto -> {
                    if (orderProductDto.getProduct().getId() == productId){
                        orderProductDto.setQuantity(orderProductDto.getQuantity()+1);
                    }
                });
                currentCustomerSession.setAttribute("cart", orderDto);
            }
        } else if(quantityAction != null && quantityAction.equals("decrease")) {
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
        } else {
            //increase product quantity in db by orderProduct quantity
            //remove orderProduct from order
            var orderDto = (OrderDto)currentCustomerSession.getAttribute("cart");
            OrderProductDto orderProductDto = null;
            for(var orderProduct : orderDto.getOrderProducts()){
                if (orderProduct.getProduct().getId() == productId){
                    DomainFacade.getInstance().deleteProductFromShoppingCart(productId, orderProduct.getQuantity());
                    orderProductDto = orderProduct;
                }
            }
            currentCustomerSession.setAttribute("cart", orderDto);
            if(!orderProductDto.equals(null)) orderDto.getOrderProducts().remove(orderProductDto);
        }
        resp.getWriter().print("");
    }

}