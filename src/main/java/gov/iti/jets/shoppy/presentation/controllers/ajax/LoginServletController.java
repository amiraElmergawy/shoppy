package gov.iti.jets.shoppy.presentation.controllers.ajax;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.service.util.HashManager;
import gov.iti.jets.shoppy.presentation.util.Validator;
import gov.iti.jets.shoppy.service.DomainFacade;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name = "SigninServlet" , value = "/signin")
public class LoginServletController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Validator validator = Validator.getInstance();
        DomainFacade domainFacade = DomainFacade.getInstance();
        LoginViewHelper loginViewHelper;
        loginViewHelper = domainFacade.signin(email , password);
        System.out.println("viewHelper -> dto: "+ loginViewHelper.getUserDto());
        System.out.println("error" +loginViewHelper.getError());

    }
}
