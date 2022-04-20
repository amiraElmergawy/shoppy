package gov.iti.jets.shoppy.presentation.controllers;

import gov.iti.jets.shoppy.service.DomainFacade;
import gov.iti.jets.shoppy.service.dtos.OrderDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "CheckoutServletController", value = "/checkout")
public class CheckoutServletController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var currentCustomerSession = request.getSession(false);
        var orderDto = (OrderDto)currentCustomerSession.getAttribute("cart");
        if(orderDto != null){ //check for this in front before click the button
            orderDto.setIsSubmitted(true);
            System.out.println(orderDto);
            if (orderDto.getOrderProducts().size() != 0)
                if(!DomainFacade.getInstance().saveOrderWithCreditLimit(Optional.of(orderDto)))
                    response.getWriter().print("please update your credit limit");
                else
                    response.getWriter().print("");
            else
                response.getWriter().print("your order is empty");
        }
    }

}
