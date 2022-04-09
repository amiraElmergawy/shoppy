package gov.iti.jets.shoppy.presentation.controllers;

import gov.iti.jets.shoppy.service.DomainFacade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Welcome" , value = "")
public class WelcomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie check = new Cookie("Check" , "yes");
        if(req.getCookies() == null){
            resp.addCookie(check);
        }
        resp.sendRedirect("home");
    }
}