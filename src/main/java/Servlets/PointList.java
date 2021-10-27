/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import com.project.heracliontravelassistant.db.PointDB;
import com.project.heracliontravelassistant.model.SimplePoint;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "PointList", urlPatterns = {"/PointList"})
public class PointList extends HttpServlet {

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

        List<SimplePoint> Points;
        Points = PointDB.getPointS();

        List<SimplePoint> food = new ArrayList<>();
        List<SimplePoint> sight = new ArrayList<>();
        List<SimplePoint> pharma = new ArrayList<>();
        List<SimplePoint> beach = new ArrayList<>();
        List<SimplePoint> cafe = new ArrayList<>();
        List<SimplePoint> hotel = new ArrayList<>();

        int i = 0;
        SimplePoint p;
        while (i < Points.size()) {
            //System.out.println(Points.get(i).getName());
            switch (Points.get(i).getType()) {
                case "food":
                    p = Points.get(i);
                    food.add(p);
                    break;
                case "Sight":
                    p = Points.get(i);
                    sight.add(p);
                    break;
                case "Cafe":
                    p = Points.get(i);
                    cafe.add(p);
                    break;
                case "Beach":
                    p = Points.get(i);
                    beach.add(p);
                    break;
                case "Pharma":
                    p = Points.get(i);
                    pharma.add(p);
                    break;
                case "Hotel":
                    p = Points.get(i);
                    hotel.add(p);
                    break;
                default:
                    break;
            }
            i++;
        }

        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<h5>Sights-Archeological Places</h5>");
            out.println("<ol>");
            i = 0;
            while (i < sight.size()) {
                out.println("<li>" + sight.get(i).getName() + "</li>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick='edit1(" + "\"" + sight.get(i).getName() + "\"" + ")'>Edit</button><button type=\"button\" class=\"btn btn-danger btn-sm\" onclick='del1(" + "\"" + sight.get(i).getName() + "\"" + ")'>Del</button>");
                i++;
            }
            out.println("</ol>");
            out.println("<h5>Restaurants</h5>");
            out.println("<ol>");
            i = 0;
            while (i < food.size()) {
                out.println("<li>" + food.get(i).getName() + "</li>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick='edit1(" + "\"" + food.get(i).getName() + "\"" + ")'>Edit</button><button type=\"button\" class=\"btn btn-danger btn-sm\" onclick='del1(" + "\"" + food.get(i).getName() + "\"" + ")'>Del</button>");
                i++;
            }
            out.println("</ol>");
            out.println("<h5>Cafe-Bars</h5>");
            out.println("<ol>");
            i = 0;
            while (i < cafe.size()) {
                out.println("<li>" + cafe.get(i).getName() + "</li>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-sm\"onclick='edit1(" + "\"" + cafe.get(i).getName() + "\"" + ")'>Edit</button><button type=\"button\" class=\"btn btn-danger btn-sm\" onclick='del1(" + "\"" + cafe.get(i).getName() + "\"" + ")'>Del</button>");
                i++;
            }
            out.println("</ol>");
            out.println("<h5>Beaches</h5>");
            out.println("<ol>");
            i = 0;
            while (i < beach.size()) {
                out.println("<li>" + beach.get(i).getName() + "</li>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick='edit1(" + "\"" + beach.get(i).getName() + "\"" + ")'>Edit</button><button type=\"button\" class=\"btn btn-danger btn-sm\" onclick='del1(" + "\"" + beach.get(i).getName() + "\"" + ")'>Del</button>");
                i++;
            }
            out.println("</ol>");
            out.println("<h5>Hotels</h5>");
            out.println("<ol>");
            i = 0;
            while (i < hotel.size()) {
                out.println("<li>" + hotel.get(i).getName() + "</li>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick='edit1(" + "\"" + hotel.get(i).getName() + "\"" + ")'>Edit</button><button type=\"button\" class=\"btn btn-danger btn-sm\" onclick='del1(" + "\"" + hotel.get(i).getName() + "\"" + ")'>Del</button>");
                i++;
            }
            out.println("</ol>");
            out.println("<h5>Pharmacy</h5>");
            out.println("<ol>");
            i = 0;
            while (i < pharma.size()) {
                out.println("<li>" + pharma.get(i).getName() + "</li>");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-sm\" onclick='edit1(" + "\"" + pharma.get(i).getName() + "\"" + ")'>Edit</button><button type=\"button\" class=\"btn btn-danger btn-sm\" onclick='del1(" + "\"" + pharma.get(i).getName() + "\"" + ")'>Del</button>");
                i++;
            }
            out.println("</ol>");
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
            Logger.getLogger(PointList.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PointList.class.getName()).log(Level.SEVERE, null, ex);
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
