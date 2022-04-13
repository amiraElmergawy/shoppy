package gov.iti.jets.shoppy.presentation.controllers;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.ProfileViewHelper;
import gov.iti.jets.shoppy.service.DomainFacade;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ProfileServletController" , value = "/profile")
public class ProfileServletController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/customer/customer-profile.jsp");
        HttpSession httpSession= req.getSession();
        int userId= (int) httpSession.getAttribute("userId");
        ProfileViewHelper profileViewHelper = DomainFacade.getInstance().customerProfile(userId);
        req.setAttribute("helper",profileViewHelper);
        System.out.println("profile view _____"+profileViewHelper);
        //loadCustomerprofile

        try {
            rd.include(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
