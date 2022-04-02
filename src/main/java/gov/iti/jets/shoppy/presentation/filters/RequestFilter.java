package gov.iti.jets.shoppy.presentation.filters;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.*;

import java.io.IOException;

public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        request.setAttribute("entityManager", ((EntityManagerFactory) request.getServletContext().getAttribute("entityManagerFactory")).createEntityManager());
        chain.doFilter(request, response);
        EntityManager entityManager = (EntityManager)request.getAttribute("entityManager");
        if (entityManager.isOpen())
            entityManager.close();
    }
}
