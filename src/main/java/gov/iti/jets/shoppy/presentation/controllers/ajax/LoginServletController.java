package gov.iti.jets.shoppy.presentation.controllers.ajax;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.service.DomainFacade;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        if(req.getSession(false) != null && req.getSession(false).getAttribute("role") != null){
            if (req.getSession(false).getAttribute("role").equals("customer") ){
                resp.sendRedirect("home");
            }else{
                resp.sendRedirect("dashboard");
            }
        }else {
            if (req.getParameter("loginBoolean") != null) {
                resp.getWriter().println("Login Failed , invalid email or password , Please Try Again");
            }
            if (req.getParameter("notValid") != null) {
                resp.getWriter().println("invalid format email or password");
            }
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/customer/auth-forms.jsp");
            try {
                rd.include(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession httpSession = req.getSession();
        LoginViewHelper loginViewHelper = DomainFacade.getInstance().signIn(email, password);
        PrintWriter writer =resp.getWriter();
//        System.out.println("Customer DTO "+loginViewHelper.getCustomerDto());
//        System.out.println("Admin Dto " + loginViewHelper.getAdminDto());
//        System.out.println("Error "+ loginViewHelper.getError());
        if (loginViewHelper.getCustomerDto() != null){
            httpSession.setAttribute("role", "customer");
            httpSession.setAttribute("data", loginViewHelper.getCustomerDto());
            resp.sendRedirect("home");
        } else if(loginViewHelper.getAdminDto() != null){
            httpSession.setAttribute("role", "admin");
            httpSession.setAttribute("data", loginViewHelper.getAdminDto());
            resp.sendRedirect("dashboard");
        }
        if(loginViewHelper.getError() != null){
            resp.sendRedirect("login?loginBoolean=false");
//            resp.getWriter().write(loginViewHelper.getError());
        }
    }
}
