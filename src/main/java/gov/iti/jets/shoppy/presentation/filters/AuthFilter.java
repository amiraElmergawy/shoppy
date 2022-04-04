package gov.iti.jets.shoppy.presentation.filters;

import jakarta.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthFilter implements Filter {

    private final List<String> urlList = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        urlList.add("");
        urlList.add("login");
        urlList.add("signIn");
        urlList.add("home");
        urlList.add("register");
        urlList.add("signUp");
        urlList.add("about-us");
        urlList.add("product-detail");
        urlList.add("product-cart");
        urlList.add("admin/add-product");
        urlList.add("admin/update-product");
        urlList.add("admin/products");
        urlList.add("admin/product-details");
        urlList.add("admin/product");
        urlList.add("admin/customers");
        urlList.add("admin/orders");
        urlList.add("admin/dashboard");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
