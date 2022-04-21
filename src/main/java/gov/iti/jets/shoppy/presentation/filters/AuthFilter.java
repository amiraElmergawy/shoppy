package gov.iti.jets.shoppy.presentation.filters;

import gov.iti.jets.shoppy.service.dtos.Role;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthFilter implements Filter {

    private final List<String> adminUrlList = new ArrayList<>();
    private final List<String> customerUrlList = new ArrayList<>();
    private final List<String> privateUrlList = new ArrayList<>();
    private final List<String> publicUrlList = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        fillCustomerUrlsList();
        fillAdminUrlsList();
        fillPrivateUrlList();
        fillPublicUrlsList();
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String requestUrl = ((HttpServletRequest) servletRequest).getRequestURL().substring(((HttpServletRequest) servletRequest).getRequestURL().lastIndexOf("/") + 1);
//        System.out.println("getRequestURL().substring: " + requestUrl);
//        System.out.println("uri: " + ((HttpServletRequest) servletRequest).getRequestURI());
        if (requestUrl.isBlank())
            ((HttpServletResponse) servletResponse).sendRedirect("home");
        else {
            if (privateUrlList.contains(requestUrl)) {
                //private urls
                HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession(false);
                if (httpSession != null) {
                    Role role = (Role) httpSession.getAttribute("userRole");
                    if (role != null) {
                        if (adminUrlList.contains(requestUrl) && !role.equals(Role.ADMIN)) {
                            ((HttpServletResponse) servletResponse).sendRedirect("not-found-page");
                        } else if (((HttpServletRequest) servletRequest).getRequestURI().contains("profile") && !role.equals(Role.CUSTOMER)) {
                            ((HttpServletResponse) servletResponse).sendRedirect("not-found-page");
                        } else if (customerUrlList.contains(requestUrl) && !(role.equals(Role.CUSTOMER) || role.equals(Role.ADMIN))) {
                            ((HttpServletResponse) servletResponse).sendRedirect("not-found-page");
                        } else {
                            filterChain.doFilter(servletRequest, servletResponse);
                        }
                    } else {
                        ((HttpServletResponse) servletResponse).sendRedirect("login");
                    }
                } else {
                    ((HttpServletResponse) servletResponse).sendRedirect("login");
                }
            } else if (publicUrlList.contains(requestUrl)) {
                //public
                if (requestUrl.equals("login") || requestUrl.equals("register")) {
                    HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession(false);
                    if (httpSession != null) {
                        Role role = (Role) httpSession.getAttribute("userRole");
                        if (role != null) {
                            if (role.equals(Role.CUSTOMER))
                                ((HttpServletResponse) servletResponse).sendRedirect("home");
                            else
                                ((HttpServletResponse) servletResponse).sendRedirect("dashboard");
                        } else filterChain.doFilter(servletRequest, servletResponse);
                    } else filterChain.doFilter(servletRequest, servletResponse);
                } else filterChain.doFilter(servletRequest, servletResponse);
            } else if (((HttpServletRequest) servletRequest).getRequestURI().contains("assets") || ((HttpServletRequest) servletRequest).getRequestURI().contains("create-payment-intent") ||
                    ((HttpServletRequest) servletRequest).getRequestURI().contains("images/C:/upload/products")) {
                //resources
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                //not exist urls
                ((HttpServletResponse) servletResponse).sendRedirect("not-found-page");
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    private void fillPrivateUrlList(){
        privateUrlList.addAll(customerUrlList);
        privateUrlList.addAll(adminUrlList);
        privateUrlList.add("logout");
    }

    private void fillCustomerUrlsList(){
//        customerList.addAll(publicUrlList);
        customerUrlList.add("shopping-cart");
        customerUrlList.add("profile");
        customerUrlList.add("add-to-cart");
        customerUrlList.add("checkout");
        customerUrlList.add("payment");
        customerUrlList.add("receipt");
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
        adminUrlList.add("delete");
        adminUrlList.add("customer-orders");
    }

    private void fillPublicUrlsList(){
       publicUrlList.add("register");
        publicUrlList.add("login");
        publicUrlList.add("home");
        publicUrlList.add("product-details");
        publicUrlList.add("about-us");
        publicUrlList.add("search");

    }
}
