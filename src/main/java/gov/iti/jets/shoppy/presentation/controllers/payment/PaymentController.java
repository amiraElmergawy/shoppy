package gov.iti.jets.shoppy.presentation.controllers.payment;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import gov.iti.jets.shoppy.presentation.dtos.CreatePaymentResponse;
import gov.iti.jets.shoppy.service.dtos.OrderDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PaymentController" , value = "/payment")
public class PaymentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/customer/payment.jsp");
        try {
            rd.include(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        OrderDto orderDto = (OrderDto) req.getSession(false).getAttribute("cart");
        if(orderDto == null)
            return;
        PrintWriter out = resp.getWriter();
        Stripe.apiKey = "sk_test_51KqLFHJsRRC8Gzw03TaqdQ7JjpXBaEJwS7QW8dD2IFPG0hcITuvGQIp5z7ZKffonM2HJqjmhG2V5b94ppzhyaNAm00iAq5XK5i";
        Gson gson = new Gson();
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount((long) orderDto.getTotalPrice())
                .setCurrency("le")
                .setCustomer(orderDto.getCustomer().getEmail())
                .setApplicationFeeAmount(50l)
                .setPaymentMethod("visa")
                .setReceiptEmail(orderDto.getCustomer().getEmail())
                .setAutomaticPaymentMethods
                        (
                                PaymentIntentCreateParams.AutomaticPaymentMethods
                                .builder()
                                .setEnabled(true)
                                .build()
                        ).build();

        PaymentIntent paymentIntent = null;
        try {
            paymentIntent = PaymentIntent.create(params);
        } catch (StripeException e) {
            e.printStackTrace();
        }

        CreatePaymentResponse paymentResponse = new CreatePaymentResponse(paymentIntent.getClientSecret());
        out.print(gson.toJson(paymentResponse));
        out.flush();
        out.close();
    }
}
