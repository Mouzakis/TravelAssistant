/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.heracliontravelassistant.db;

import com.project.heracliontravelassistant.model.Point;
import com.project.heracliontravelassistant.model.SidePoint;
import com.project.heracliontravelassistant.model.SimplePoint;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ioann
 */
public class PointDB {

    public static List<Point> getPointsxy() throws ClassNotFoundException {
        List<Point> PointsXY = new ArrayList<>();

        /*Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost";
            String databaseName = "map";
            int port = 3306;
            String username = "root";
            String password = "";

            Connection con = DriverManager.getConnection(url + ":" + port + "/" + databaseName + "?characterEncoding=UTF-8", username, password);
         */
        Statement stmt = null;
        Connection con = null;
        try {
            con = MapDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT * FROM `points`");

            stmt.execute(insQuery.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                Point point = new Point();
                point.setName(res.getString("Name"));
                point.setType(res.getString("Type"));
                point.setX(res.getDouble("x"));
                point.setY(res.getDouble("y"));

                PointsXY.add(point);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PointDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
        return PointsXY;
    }

    public static Point getPoint(String name) {
        Connection con = null;
        Statement stmt = null;
        Point point = new Point();
        try {
            con = MapDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT * FROM `points`")
                    .append(" WHERE ")
                    .append("Name = ")
                    .append("'")
                    .append(name)
                    .append("';");
            stmt.execute(insQuery.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                point.setName(res.getString("Name"));
                point.setType(res.getString("Type"));
                point.setX(res.getDouble("x"));
                point.setY(res.getDouble("y"));
                point.setAddres(res.getString("Address"));
                point.setPhone(res.getString("Phone"));
                point.setSite(res.getString("Site"));
                point.setHours(res.getString("Hours"));
                point.setInfo(res.getString("Info"));
                point.setImg(res.getString("Img"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PointDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
        return point;
    }

    public static SimplePoint getSimplePoint(String name) {
        Connection con = null;
        Statement stmt = null;
        SimplePoint point = new SimplePoint();
        try {
            con = MapDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT * FROM `points`")
                    .append(" WHERE ")
                    .append("Name = ")
                    .append("'")
                    .append(name)
                    .append("';");
            stmt.execute(insQuery.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                point.setName(res.getString("Name"));
                point.setType(res.getString("Type"));
                point.setX(res.getDouble("x"));
                point.setY(res.getDouble("y"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PointDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
        return point;
    }

    public static List<SidePoint> getPointsT(String type) throws SQLException, ClassNotFoundException {
        List<SidePoint> PointsT = new ArrayList<>();

        Statement stmt = null;
        Connection con = null;

        try {
            con = MapDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();
            insQuery.append("SELECT * FROM `points` WHERE `Type` =" + "'" + type + "'");

            stmt.execute(insQuery.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next()) {
                SidePoint point = new SidePoint(res.getString("Name"), res.getString("Type"), res.getDouble("x"), res.getDouble("y"), res.getString("Address"), res.getString("Img"));
                //System.out.println(point.toString());
                PointsT.add(point);
                //System.out.println(PointsT.get(0).toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PointDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return PointsT;
    }


    public static List<SimplePoint> getPointS() throws ClassNotFoundException {
        List<SimplePoint> Points = new ArrayList<>();
        Statement stmt = null;
        Connection con = null;
        try {
            con = MapDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT * FROM `points`");

            stmt.execute(insQuery.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                SimplePoint point = new SimplePoint();
                point.setName(res.getString("Name"));
                point.setType(res.getString("Type"));
                point.setX(res.getDouble("x"));
                point.setY(res.getDouble("y"));

                Points.add(point);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PointDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
        return Points;
        //To change body of generated methods, choose Tools | Templates.
    }

    public static void addPoint(Point p) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        try {
            con = MapDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO `points`(`Name`, `Type`, `x`, `y`, `Address`, `Phone`, `Site`, `Hours`, `Info`, `Img`) VALUES ")
                    .append('(')
                    .append('"')
                    .append(p.getName())
                    .append('"')
                    .append(',')
                    .append('"')
                    .append(p.getType())
                    .append('"')
                    .append(',')
                    .append('"')
                    .append(p.getX())
                    .append('"')
                    .append(',')
                    .append('"')
                    .append(p.getY())
                    .append('"')
                    .append(',')
                    .append('"')
                    .append(p.getAddress())
                    .append('"')
                    .append(',')
                    .append('"')
                    .append(p.getPhone())
                    .append('"')
                    .append(',')
                    .append('"')
                    .append(p.getSite())
                    .append('"')
                    .append(',')
                    .append('"')
                    .append(p.getHours())
                    .append('"')
                    .append(',')
                    .append('"')
                    .append(p.getInfo())
                    .append('"')
                    .append(',')
                    .append('"')
                    .append(p.getImg())
                    .append('"')
                    .append(')');

            stmt.execute(insQuery.toString());


        } catch (SQLException ex) {
            Logger.getLogger(PointDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
    }

    public static void updatePoint(String name, Point p) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        try {
            con = MapDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("UPDATE `points` SET")
                    .append("`Name`=")
                    .append('"')
                    .append(p.getName())
                    .append('"')
                    .append(',')
                    .append("`Type`=")
                    .append('"')
                    .append(p.getType())
                    .append('"')
                    .append(',')
                    .append("`x`=")
                    .append('"')
                    .append(p.getX())
                    .append('"')
                    .append(',')
                    .append("`y`=")
                    .append('"')
                    .append(p.getY())
                    .append('"')
                    .append(',')
                    .append("`Address`=")
                    .append('"')
                    .append(p.getAddress())
                    .append('"')
                    .append(',')
                    .append("`Phone`=")
                    .append('"')
                    .append(p.getPhone())
                    .append('"')
                    .append(',')
                    .append("`Site`=")
                    .append('"')
                    .append(p.getSite())
                    .append('"')
                    .append(',')
                    .append("`Hours`=")
                    .append('"')
                    .append(p.getHours())
                    .append('"')
                    .append(',')
                    .append("`Info`=")
                    .append('"')
                    .append(p.getInfo())
                    .append('"')
                    .append(',')
                    .append("`Img`=")
                    .append('"')
                    .append(p.getImg())
                    .append('"')
                    .append("WHERE")
                    .append("`Name`=")
                    .append('"')
                    .append(name)
                    .append('"');


            stmt.execute(insQuery.toString());

        } catch (SQLException ex) {
            Logger.getLogger(PointDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
    }

    public static void deletePoint(String name) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        try {
            con = MapDB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("DELETE FROM `points` WHERE `Name`")
                    .append('=')
                    .append('"')
                    .append(name)
                    .append('"');

            stmt.execute(insQuery.toString());

        } catch (SQLException ex) {
            Logger.getLogger(PointDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
    }

    private static void closeDBConnection(Statement stmt, Connection con) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Point.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Point.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
