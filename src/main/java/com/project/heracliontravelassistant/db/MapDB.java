/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.heracliontravelassistant.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MapDB {
    private static final String URL = "jdbc:mysql://localhost";
    private static final String DATABASE = "map";
    private static final int PORT = 3306;
    private static final String UNAME = "root";
    private static final String PASSWD = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL + ":" + PORT + "/" + DATABASE, UNAME, PASSWD);
    }
}
