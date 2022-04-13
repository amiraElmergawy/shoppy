package gov.iti.jets.shoppy.presentation.filters;

import com.mysql.cj.xdevapi.JsonString;
import gov.iti.jets.shoppy.presentation.util.JSONConverter;
import gov.iti.jets.shoppy.presentation.util.Validator;
import gov.iti.jets.shoppy.service.dtos.CustomerDto;
import gov.iti.jets.shoppy.service.dtos.customer.CustomerPostRequestDto;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
                System.out.println(req.getParameter("customerData"));
                CustomerPostRequestDto customerDto = JSONConverter.JSONToCustomerDto(req.getParameter("customerData"));
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
