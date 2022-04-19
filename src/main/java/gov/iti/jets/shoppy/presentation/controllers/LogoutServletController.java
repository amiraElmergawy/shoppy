package gov.iti.jets.shoppy.presentation.controllers;

import gov.iti.jets.shoppy.presentation.util.CookieUtility;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LogoutServletController", value = "/logout")
public class LogoutServletController extends HttpServlet {
    private final CookieUtility cookieUtility = CookieUtility.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cookieUtility.removeUIDToken(req, resp);
        req.getSession().invalidate();
        resp.sendRedirect("home");

    }
}
