/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAL.ImageSourceDAO;
import DAL.ProductDAO;
import Entity.ImageSource;
import Entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Windows 10 Version 2
 */
public class HomepageController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProductDAO dao = new ProductDAO();
        ImageSourceDAO isDAO = new ImageSourceDAO();
        try {
            int maxPage = (int) Math.ceil(dao.countProduct() / 3.0);
            request.setAttribute("maxPage", maxPage);
            String pageIndex = request.getParameter("page");
            if (pageIndex == null || pageIndex.equals("")) {
                pageIndex = "0";
            }
            int page = Integer.parseInt(pageIndex);
            request.setAttribute("page", page);
            List<Product> pdts = dao.listProduct(page, 3);
            request.setAttribute("products", pdts);
            
            ImageSource img = isDAO.getImageById(2);
            request.setAttribute("banner", img.getPath());
            
            request.setAttribute("active", "home");
            request.getRequestDispatcher("Homepage.jsp").forward(request, response);

        } catch (IOException | ServletException e) {
            System.out.println(e.toString());
            response.sendRedirect("Error.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
