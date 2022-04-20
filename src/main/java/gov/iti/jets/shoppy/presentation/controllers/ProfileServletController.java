package gov.iti.jets.shoppy.presentation.controllers;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.presentation.helpers.ProfileViewHelper;
import gov.iti.jets.shoppy.service.DomainFacade;
import gov.iti.jets.shoppy.service.dtos.AddressDto;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import gov.iti.jets.shoppy.service.util.HashManager;
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
        System.out.println("cridur___"+profileViewHelper.getCustomerDto().getCreditLimit());
        String gender="Female";
        if(profileViewHelper.getCustomerDto().isMale()==true){
            gender="Male";
        }
        req.setAttribute("genderValue",gender);

        try {
            rd.include(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession= req.getSession();
        int userId= (int) httpSession.getAttribute("userId");
        System.out.println("first line post method");
        Date formattedDOB = new Date();
        System.out.println(formattedDOB);

        try {
            formattedDOB = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("date").trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("************ before customer dto --------");
        AddressDto addressDto=AddressDto.builder()
                .street(req.getParameter("street"))
                .area(req.getParameter("city"))
                .buildingNum(Integer.valueOf(req.getParameter("buildingNum")))
                .floorNum(Integer.valueOf(req.getParameter("floorNum")))
                .build();
        CustomerDto customerDto = CustomerDto.builder()
                .username(req.getParameter("username").trim())
                .dob(formattedDOB)
                .address(addressDto)
                .interests(req.getParameter("interests").trim())
                .job(req.getParameter("job"))
                .isMale(Boolean.parseBoolean(req.getParameter("gender")))
                .build();

        System.out.println("customer dto --------"+customerDto);
        if(DomainFacade.getInstance().updateProfile(userId,customerDto,addressDto))
            resp.sendRedirect("profile");
        else {
            resp.sendRedirect("profile?updateError=false");
        }

    }
}
