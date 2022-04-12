package gov.iti.jets.shoppy.presentation.controllers.ajax;

import gov.iti.jets.shoppy.service.DomainFacade;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import gov.iti.jets.shoppy.service.util.HashManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

@WebServlet (name = "RegisterServletController" , value = "/register")
public class RegisterServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/customer/auth-forms.jsp");
        try {
            rd.include(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
        String name= req.getParameter("name").trim();
        String email= req.getParameter("email").trim();
        String password= req.getParameter("password").trim();
        String birthDate= req.getParameter("birthDate").trim();
        String favorite= req.getParameter("favorite").trim();
        String gender = req.getParameter("gender").trim();
        boolean isMale = gender == "male"? true : false;
        Date formattedDOB = new Date();
        System.out.println(formattedDOB);
        try {
            formattedDOB = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CustomerDto customerDto = CustomerDto.builder()
                .username(name)
                .email(email)
                .password(HashManager.INSTANCE.generateSecurePassword(password))
                .dateOfBirth(formattedDOB)
                .isMale(isMale)
                .interests(favorite).build();
        System.out.println(customerDto);
        if(DomainFacade.getInstance().signUp(customerDto))
            resp.sendRedirect("login");
        else {
            resp.sendRedirect("register?emailValidation=false");
        }
    }

}
