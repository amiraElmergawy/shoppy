package gov.iti.jets.shoppy.presentation.controllers.ajax;

import com.google.gson.Gson;
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
import java.util.List;

@WebServlet(name = "AdminAddProductServletController" , value = "/add-product")
public class AdminAddProductServletController extends HttpServlet {
    private final DomainFacade domainFacade = DomainFacade.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/admin/add-product.jsp");
        try {
            rd.include(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<String> encodedImages = new Gson().fromJson(req.getParameter("images"), List.class);
            ProductDto productDto = ProductDto.builder()
                  .productDesc(req.getParameter("desc"))
                  .productName(req.getParameter("productName"))
                  .stock(Integer.valueOf(req.getParameter("stock")))
                  .price(Double.parseDouble(req.getParameter("price")))
                  .category(ProductCategory.valueOf(req.getParameter("category")))
                  .imagesPaths(encodedImages).build();
            boolean isAdded = domainFacade.addProduct(productDto);
            try {
//                if(isAdded){
//                    req.setAttribute("isAdded","true");
//                }
                RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/admin/add-product.jsp");
                rd.forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            }
    }
}
