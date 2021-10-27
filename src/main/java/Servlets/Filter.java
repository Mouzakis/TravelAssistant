/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import com.project.heracliontravelassistant.db.PointDB;
import com.project.heracliontravelassistant.model.SidePoint;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "Filter", urlPatterns = {"/Filter"})
public class Filter extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        String type;
        List<SidePoint> PointsT;
        response.setContentType("text/html;charset=UTF-8");

        type = request.getParameter("type");

        PointsT = PointDB.getPointsT(type);

        try ( PrintWriter out = response.getWriter()) {
            int i;
            /* TODO output your page here. You may use following sample code. */

            for (i = 0; i < PointsT.size(); i++) {
                out.println("<button onclick='filterBtn(" + "\"" + PointsT.get(i).getName() + "\"" + ")' class='container-fluid fbtn' id='" + PointsT.get(i).getName() + "'" + ">\n"
                        + "<div class=\"row\">\n"
                        + "<div class=\"col\">\n"
                        + "<h5 id=\"pnameinner\">" + PointsT.get(i).getName() + "</h5>\n"
                        + "<p>" + PointsT.get(i).getAddress() + "</p>\n"
                        + "<p style=\"color: green;\">Open Now</p>\n"
                        + "</div>\n"
                        + "<img src=\"" + PointsT.get(i).getImg() + "\"alt=\"point img\" class=\"rounded float-right fres\" width=\"100px\" height=\"100px\">\n"
                        + "</div>\n"
                        + "</button>");
            }
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
        } catch (SQLException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
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
