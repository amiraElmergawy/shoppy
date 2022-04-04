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
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
