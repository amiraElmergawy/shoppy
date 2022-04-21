package gov.iti.jets.shoppy.presentation.controllers;

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
import java.util.Optional;

@WebServlet(name = "PaymentRespServletController", value = "/receipt")
public class PaymentRespServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/customer/receipt.jsp");
        try {
            HttpSession currentCustomerSession = req.getSession(false);
            OrderDto orderDto = (OrderDto)currentCustomerSession.getAttribute("cart");
            if(orderDto != null){
                orderDto.setIsSubmitted(true);
                DomainFacade.getInstance().saveOrderWithVisa(Optional.of(orderDto));
            }
            currentCustomerSession.setAttribute("cart", null);
            req.setAttribute("order", orderDto);
            rd.include(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
