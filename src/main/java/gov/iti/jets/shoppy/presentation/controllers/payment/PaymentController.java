package gov.iti.jets.shoppy.presentation.controllers.payment;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import gov.iti.jets.shoppy.presentation.dtos.CreatePaymentResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PaymentController" , value = "/create-payment-intent")
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
        PrintWriter out = resp.getWriter();
        Stripe.apiKey = "sk_test_51KqLFHJsRRC8Gzw03TaqdQ7JjpXBaEJwS7QW8dD2IFPG0hcITuvGQIp5z7ZKffonM2HJqjmhG2V5b94ppzhyaNAm00iAq5XK5i";

        Gson gson = new Gson();
            PaymentIntentCreateParams params =
                    PaymentIntentCreateParams.builder()
                            .setAmount(50*1400L)
                            .setCurrency("usd")
                            .setAutomaticPaymentMethods(
                                    PaymentIntentCreateParams.AutomaticPaymentMethods
                                            .builder()
                                            .setEnabled(true)
                                            .build()
                            )
                            .build();

            // Create a PaymentIntent with the order amount and currency
        PaymentIntent paymentIntent = null;
        try {
            paymentIntent = PaymentIntent.create(params);
        } catch (StripeException e) {
            e.printStackTrace();
        }

        CreatePaymentResponse paymentResponse = new CreatePaymentResponse(paymentIntent.getClientSecret());
        out.print(gson.toJson(paymentResponse));
        out.flush();
        System.out.println(gson.toJson(paymentResponse));
    }
}
