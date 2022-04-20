package gov.iti.jets.shoppy.presentation.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PaymentRespServle", value = "/receipt")
public class PaymentRespServle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/customer/receipt.jsp");
        try {
            rd.include(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
