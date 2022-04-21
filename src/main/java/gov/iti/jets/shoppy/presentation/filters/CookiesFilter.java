package gov.iti.jets.shoppy.presentation.filters;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import gov.iti.jets.shoppy.presentation.util.CookieUtility;
import gov.iti.jets.shoppy.presentation.util.SessionManager;
import gov.iti.jets.shoppy.service.DomainFacade;
import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CookiesFilter implements Filter {
    private final CookieUtility cookieUtility = CookieUtility.INSTANCE;
    private final DomainFacade domainFacade = DomainFacade.getInstance();
    private final SessionManager sessionManager = SessionManager.INSTANCE;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res =(HttpServletResponse) response;

        Cookie check = new Cookie("Check" , "yes");
        if(req.getCookies() == null){
            res.addCookie(check);
        }

        if (req.getRequestURI().equals("/shoppy/")){
            filterChain.doFilter(request , response);
        }else{
            Cookie[] cookies =req.getCookies();
            if (cookies==null){
                 RequestDispatcher rd = req.getRequestDispatcher("Cookie.jsp");
                 rd.include(req,res);
            }else {
                handleRememberMe(req, res);
                filterChain.doFilter(request , response);
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    private void handleRememberMe(HttpServletRequest req, HttpServletResponse resp){
        cookieUtility.readUIDCookie(req).ifPresent(cookie -> {
            LoginViewHelper loginViewHelper = domainFacade.rememberMe(Long.parseLong(cookie.getValue()));
            if(loginViewHelper.getError() == null)
                sessionManager.createSession(req, loginViewHelper);
        });
    }
}
