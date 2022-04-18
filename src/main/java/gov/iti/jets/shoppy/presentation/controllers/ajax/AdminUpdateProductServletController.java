package gov.iti.jets.shoppy.presentation.controllers.ajax;

import gov.iti.jets.shoppy.repository.entity.ProductCategory;
import gov.iti.jets.shoppy.service.DomainFacade;
import gov.iti.jets.shoppy.service.dtos.ProductDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminUpdateProductServletController" , value = "/update-product")
public class AdminUpdateProductServletController extends HttpServlet {
    private final DomainFacade domainFacade = DomainFacade.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/admin/update-product.jsp");
        try {
            req.setAttribute("productDto", domainFacade.getProductById(Integer.parseInt(req.getParameter("productID"))).getProductDto());
            rd.include(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in do post");
        int productId = Integer.parseInt(req.getParameter("id"));

        System.out.println(ProductCategory.valueOf(req.getParameter("category")));


        ProductDto productDto = ProductDto.builder().productDesc(req.getParameter("desc")).
                productName(req.getParameter("productName")).stock(Integer.valueOf(req.getParameter("stock")))
                .price(Double.valueOf(req.getParameter("price"))).category(ProductCategory.valueOf(req.getParameter("category"))).id(productId).build();
        boolean isAdded = domainFacade.updateProduct(productDto,productId);
        System.out.println(isAdded);
        try {
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/admin/update-product.jsp");
            rd.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
}
