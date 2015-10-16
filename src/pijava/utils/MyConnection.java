/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.utils;

import java.sql.*;

/**
 *
 * @author sana
 */
public class MyConnection {

    private static Connection con;
    private String url = "jdbc:mysql://localhost:3306/PIDEV";
    private String user = "root";
    private String pwd = "";
    private MyConnection() {
        try {
            con = DriverManager.getConnection(url, user, pwd);
            System.out.println("connexion");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public  static Connection getInstance()
    {
    if(con==null)
        new MyConnection();
    return con;
    }
}
