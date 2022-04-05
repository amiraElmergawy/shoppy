package gov.iti.jets.shoppy.presentation.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthFilter implements Filter {

    private final List<String> urlList = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        urlList.add("");
        urlList.add("login");
        urlList.add("home");
        urlList.add("register");
        urlList.add("about-us");
        urlList.add("product-details");
        urlList.add("shopping-cart");
        urlList.add("add-product");
        urlList.add("update-product");
        urlList.add("show-all-products");
        urlList.add("show-product");//admin
//        urlList.add("admin/product");
        urlList.add("show-all-customers");
        urlList.add("show-all-orders");
        urlList.add("dashboard");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//       HttpServletRequest request = (HttpServletRequest) servletRequest;
//        System.out.println("url "+((HttpServletRequest) servletRequest).getRequestURL());
//        System.out.println("path "+request.getContextPath());
        HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession(false);
        if (httpSession != null){
            System.out.println("from auth filter, http session is not null");
            String role = (String) httpSession.getAttribute("role");
            if(role != null){
                System.out.println("role not null: "+role);
                if (role.equals("admin"))
                    System.out.println("this is the admin");
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
