package gov.iti.jets.shoppy.presentation.controllers;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.presentation.util.CookieUtility;
import gov.iti.jets.shoppy.presentation.util.SessionManager;
import gov.iti.jets.shoppy.service.DomainFacade;
import gov.iti.jets.shoppy.service.dtos.Role;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "LoginServletController" , value = "/login")
public class LoginServletController extends HttpServlet {
    private final SessionManager sessionManager = SessionManager.INSTANCE;
    private final CookieUtility cookieUtility = CookieUtility.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/customer/auth-forms.jsp");
        try {
            rd.include(req,resp);
        } catch (ServletException e) {
           e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        LoginViewHelper loginViewHelper = DomainFacade.getInstance().signIn(email, password);
        if(loginViewHelper.getError() == null) {
            sessionManager.createSession(req, loginViewHelper);
            if (remember != null)
                cookieUtility.addUIDToken(loginViewHelper.getId(), resp);
            if (loginViewHelper.getRole().equals(Role.CUSTOMER)) {
                resp.sendRedirect("home");
            } else
                resp.sendRedirect("dashboard");
        }
        else {
            req.setAttribute("error", loginViewHelper.getError());
            req.getRequestDispatcher("WEB-INF/views/customer/auth-forms.jsp").forward(req, resp);
        }
    }
}
