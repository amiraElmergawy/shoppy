package gov.iti.jets.shoppy.presentation.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthFilter implements Filter {

    private final List<String> adminUrlList = new ArrayList<>();
    private final List<String> customerList = new ArrayList<>();
    private final List<String> privateUrlList = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        fillCustomerUrlsList();
        fillAdminUrlsList();
        fillPrivateUrlList();
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String requestUrl = ((HttpServletRequest) servletRequest).getRequestURL().substring(((HttpServletRequest) servletRequest).getRequestURL().lastIndexOf("/")+1);
//        System.out.println(requestUrl);
        if (privateUrlList.contains(requestUrl)){
            HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession(false);
            if (httpSession != null) {
                System.out.println("from auth filter, http session is not null");
                String role = (String) httpSession.getAttribute("role");
                if(!role.equals(null)){
                    System.out.println("role is: "+role);
                    if (adminUrlList.contains(requestUrl) && !role.equals("admin")){
                        ((HttpServletResponse) servletResponse).sendRedirect("not-found-page");
                    } else if (customerList.contains(requestUrl) && !(role.equals("customer") || role.equals("admin")) ) {
                        ((HttpServletResponse) servletResponse).sendRedirect("not-found-page");
                    } else {
                        filterChain.doFilter(servletRequest, servletResponse);
                    }
                } else {
                    ((HttpServletResponse) servletResponse).sendRedirect("not-found-page");
                }
            } else {
                ((HttpServletResponse) servletResponse).sendRedirect("not-found-page");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    private void fillPrivateUrlList(){
        privateUrlList.addAll(customerList);
        privateUrlList.addAll(adminUrlList);
    }

    private void fillCustomerUrlsList(){
//        customerList.addAll(publicUrlList);
        customerList.add("shopping-cart");

    }

    private void fillAdminUrlsList(){
//        adminUrlList.addAll(customerList);
        adminUrlList.add("add-product");
        adminUrlList.add("update-product");
        adminUrlList.add("show-all-products");
        adminUrlList.add("show-product");//admin
//        adminUrlList.add("admin/product");
        adminUrlList.add("show-all-customers");
        adminUrlList.add("show-all-orders");
        adminUrlList.add("dashboard");
    }
}
