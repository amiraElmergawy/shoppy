package gov.iti.jets.shoppy.presentation.controllers;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.ProfileViewHelper;
import gov.iti.jets.shoppy.service.DomainFacade;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        System.out.println("____________*******________"+ dateFormat.format(profileViewHelper.getCustomerDto().getDateOfBirth().toString()));


        try {
            rd.include(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        CustomerPostRequestDto customerReqDto = (CustomerPostRequestDto) req.getAttribute("customerData");
//        Date formattedDOB = new Date();
//        System.out.println(formattedDOB);
//        try {
//            formattedDOB = new SimpleDateFormat("yyyy-MM-dd").parse(customerReqDto.getDateOfBirth().trim());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        CustomerDto customerDto = CustomerDto.builder()
//                .username(customerReqDto.getUsername().trim())
//                .email(customerReqDto.getEmail().trim())
//                .dateOfBirth(formattedDOB)
//                .isMale(customerReqDto.isMale())
//                .interests(customerReqDto.getInterests().trim()).build();
//        System.out.println(customerDto);
//        if(DomainFacade.getInstance().updateProfile(customerDto))
//            resp.sendRedirect("profile");
//        else {
//            resp.sendRedirect("profile?updateError=false");
//        }

    }
}
