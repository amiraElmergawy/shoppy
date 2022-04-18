package gov.iti.jets.shoppy.presentation.filters;

import gov.iti.jets.shoppy.presentation.util.Validator;
import gov.iti.jets.shoppy.presentation.dtos.CustomerPostRequestDto;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ValidationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Validator validator = Validator.getInstance();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res =(HttpServletResponse) response;

        if ((req.getMethod()).equals("GET")){
            chain.doFilter(req,res);
        } else {
            if ((req.getRequestURI()).equals("/shoppy/login")){
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                if (validator.validateLoginFields(email , password)){
                    chain.doFilter(req,res);
                } else {
                    res.sendRedirect("login?notValid=false");
//                    res.getWriter().write("invalid format email or password");
                }
            }
            else if((req.getRequestURI()).equals("/shoppy/register")){
                String gender = req.getParameter("isMale").trim();
                boolean isMale = gender.equals("male")? true : false;
                CustomerPostRequestDto customerDto = new CustomerPostRequestDto(req.getParameter("username").trim(),req.getParameter("email").trim(),req.getParameter("password").trim(),req.getParameter("interests").trim(),isMale,req.getParameter("dateOfBirth").trim());
                System.out.println(customerDto);
                req.setAttribute("customerData", customerDto);
                if(validator.validateSignupFields(customerDto)){
                    chain.doFilter(req,res);
                } else {
                    res.sendRedirect("register?dataValidation=false");
                }
            } else {
                chain.doFilter(req,res);
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
