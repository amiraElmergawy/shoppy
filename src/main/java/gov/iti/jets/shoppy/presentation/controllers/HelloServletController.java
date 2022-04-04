package gov.iti.jets.shoppy.presentation.controllers;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServletController extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/admin/add-product.jsp");
        try {
            rd.include(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}