package gov.iti.jets.shoppy.presentation.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;

@WebServlet(name = "ImagesServletController", value = {"/images/*"})
public class ImagesServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imagePath = null;
        try {
            imagePath = new URI(req.getRequestURI().substring(15)).getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try(OutputStream out = resp.getOutputStream();
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(imagePath)) {
            int i;
            while ((i=fileInputStream.read()) != -1) {
                out.write(i);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
