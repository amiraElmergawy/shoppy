package gov.iti.jets.shoppy.presentation.filters;

import gov.iti.jets.shoppy.presentation.util.Validator;
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
        }else {
            System.out.println("this is post methode");
            if ((req.getRequestURI()).equals("/shoppy/login")){
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                System.out.println("this is login page");
                if (validator.validateLoginFields(email , password)){
                    chain.doFilter(req,res);
                }else {
                    res.sendRedirect("login?notValid=false");
//                    res.getWriter().write("invalid format email or password");
                }
            }
            else if((req.getRequestURI()).equals("/shoppy/register")){

                String name= req.getParameter("name");
                String email= req.getParameter("email");
                String password= req.getParameter("password");
                String birthDate= req.getParameter("birthDate");
                String favorite= req.getParameter("favorite");
                String gender = req.getParameter("gender");
                if(validator.validateSignupFields( name, email, password, birthDate,favorite, gender)){
                    chain.doFilter(req,res);
                }else {
                    res.sendRedirect("register?dataValidation=false");
                }


            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
