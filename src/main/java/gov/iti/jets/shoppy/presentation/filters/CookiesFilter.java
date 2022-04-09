package gov.iti.jets.shoppy.presentation.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CookiesFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res =(HttpServletResponse) response;
//        PrintWriter printWriter = res.getWriter();

        if (req.getRequestURI().equals("/shoppy/")){
            filterChain.doFilter(request , response);
        }else{
            Cookie[] cookies =req.getCookies();
            if (cookies==null){
                //replace this by include jsp has error when close cookies
//                printWriter.println("<p>YOU ARE Disable Cookies , we use it please Enable it :) </p>");
            }else {
                filterChain.doFilter(request , response);
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    }
