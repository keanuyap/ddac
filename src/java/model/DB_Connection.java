/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author th3-k
 */
public class DB_Connection {

    public static void main(String[] args) {
        DB_Connection dbc = new DB_Connection();
        System.out.println(dbc.getConnection());
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ddac?useSSL=false", "root", "Diam7lao0o");
            con = DriverManager.getConnection("jdbc:mysql://ddacassignmenttp034739.mysql.database.azure.com:3306/ddac?useSSL=true&requireSSL=false", "keanu@ddacassignmenttp034739", "Diam7lao0o");
            
            System.out.println("Connection to DB is successful");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}
