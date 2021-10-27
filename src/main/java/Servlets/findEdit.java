/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import com.project.heracliontravelassistant.db.PointDB;
import com.project.heracliontravelassistant.model.Point;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ioann
 */
@WebServlet(name = "findEdit", urlPatterns = {"/findEdit"})
public class findEdit extends HttpServlet {

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

        Point p = PointDB.getPoint(request.getParameter("name"));

        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<form>");
            out.println("<label for=\"name\">Name:</label><br>");
            out.println("<input type=\"text\" id=\"pname1\" name=\"\" value='" + p.getName() + "'><br>");
            out.println("<label for=\"type\">Type:</label><br>");
            out.println("<input type=\"text\" id=\"ptype1\" name=\"\" value='" + p.getType() + "'><br>");
            out.println("<label for=\"x\">X coord:</label><br>");
            out.println("<input type=\"text\" id=\"px1\" name=\"\" value='" + p.getX() + "'><br>");
            out.println("<label for=\"y\">Y coord:</label><br>");
            out.println("<input type=\"text\" id=\"py1\" name=\"\" value='" + p.getY() + "'><br>");
            out.println("<label for=\"Address\">Address:</label><br>");
            out.println("<input type=\"text\" id=\"padd1\" name=\"\" value='" + p.getAddress() + "'><br>");
            out.println("<label for=\"Hours\">Working Hours:</label><br>");
            out.println("<input type=\"text\" id=\"phours1\" name=\"\" value='" + p.getHours() + "'><br>");
            out.println("<label for=\"Phone\">Phone:</label><br>");
            out.println("<input type=\"tel\" id=\"ptel1\" name=\"\" value='" + p.getPhone() + "'><br>");
            out.println("<label for=\"Site\">Website:</label><br>");
            out.println("<input type=\"url\" id=\"psite1\" name=\"\" value='" + p.getSite() + "'><br>");
            out.println("<label for=\"Img\">Image Url:</label><br>");
            out.println("<input type=\"url\" id=\"pimg1\" name=\"\" value='" + p.getImg() + "'><br>");
            out.println("<label for=\"Site\">Information:</label><br>");
            out.println("<input type=\"text\" id=\"pinfo1\" name=\"\" value='" + p.getInfo() + "'><br>");
            out.println("<div class=\"sideparts\"><button type=\"button\" class=\"btn btn-success adminbtn\" onclick='updatePoint(" + "\"" + p.getName() + "\"" + ")'>Submit</button></div>");
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
