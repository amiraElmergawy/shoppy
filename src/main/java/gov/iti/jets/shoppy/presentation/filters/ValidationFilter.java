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
        PrintWriter printWriter = res.getWriter();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if ((req.getMethod()).equals("GET")){
            chain.doFilter(req,res);
        }else {
            System.out.println("this is post methode");
            if ((req.getRequestURI()).equals("/shoppy/login")){
                System.out.println("this is login page");
                if (validator.validateLoginFields(email , password)){
                    chain.doFilter(req,res);
                }else {
                    res.sendRedirect("login?notValid=false");
//                    res.getWriter().write("invalid format email or password");
                }
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
