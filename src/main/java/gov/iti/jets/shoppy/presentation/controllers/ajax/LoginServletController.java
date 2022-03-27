package gov.iti.jets.shoppy.presentation.controllers.ajax;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.presentation.util.HashManager;
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
        String hashedPassword = HashManager.INSTANCE.generateSecurePassword(password);
        Validator validator = Validator.getInstance();
        DomainFacade domainFacade = DomainFacade.getInstance();
        LoginViewHelper loginViewHelper;
        System.out.println(email);
        System.out.println(password);

        System.out.println(validator.validateEmail(email));
        System.out.println(validator.validatePassword(password));

        System.out.println(hashedPassword);
        System.out.println("test password"+HashManager.INSTANCE.generateSecurePassword("12345678"));

       loginViewHelper = domainFacade.signin(email , hashedPassword);
       System.out.println(loginViewHelper.getUserDto());
       System.out.println(loginViewHelper.getError());

    }
}
