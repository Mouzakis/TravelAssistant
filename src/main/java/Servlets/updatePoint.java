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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ioann
 */
@WebServlet(name = "updatePoint", urlPatterns = {"/updatePoint"})
public class updatePoint extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        String name1 = request.getParameter("name1");
        Point p = new Point(
                request.getParameter("name"),
                request.getParameter("type"),
                Double.parseDouble(request.getParameter("x")),
                Double.parseDouble(request.getParameter("y")),
                request.getParameter("addr"),
                request.getParameter("phone"),
                request.getParameter("site"),
                request.getParameter("hours"),
                request.getParameter("info"),
                request.getParameter("img")
        );

        PointDB.updatePoint(name1, p);

        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
 /*out.println("<p>" + request.getParameter("name1") + "</p>");
            out.println("<p>" + request.getParameter("name") + "</p>");
            out.println("<p>" + request.getParameter("type") + "</p>");
            out.println("<p>" + request.getParameter("x") + "</p>");
            out.println("<p>" + request.getParameter("y") + "</p>");
            out.println("<p>" + request.getParameter("addr") + "</p>");
            out.println("<p>" + request.getParameter("hours") + "</p>");
            out.println("<p>" + request.getParameter("phone") + "</p>");
            out.println("<p>" + request.getParameter("site") + "</p>");
            out.println("<p>" + request.getParameter("img") + "</p>");
            out.println("<p>" + request.getParameter("info") + "</p>");*/
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updatePoint.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updatePoint.class.getName()).log(Level.SEVERE, null, ex);
        }
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
