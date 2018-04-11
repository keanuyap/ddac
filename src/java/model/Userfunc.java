/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
 * 
 * @author th3-k
 */
public class Userfunc {

    public Userfunc() {
    }

    public void registerAgent(MLuser u) {
        Connection con = null;
        try {
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("insert into mluser values ('" + u.getId() + "','" + u.getFname() + "','" + u.getGender() + "','" + u.getLname() + "','" + u.getPassword() + "','" + u.getPosition() + "','" + u.getStatus() + "')");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Userfunc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public MLuser searchAgent(String targetID) {
        MLuser mu = new MLuser();
        Connection con = null;
        try {
            
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM mluser WHERE id = '" + targetID + "'");
            if (rs.next()) {
                mu.setId(rs.getString("id"));
                mu.setFname(rs.getString("fname"));
                mu.setLname(rs.getString("lname"));
                mu.setGender(rs.getString("gender"));
                mu.setPassword(rs.getString("password"));
                mu.setPosition(rs.getString("position"));
                mu.setStatus(rs.getString("status"));
                
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Userfunc.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
           
        }
         return mu;
    }

    public MLuser Login(String targetID, String password) {
 
        MLuser mu = new MLuser();
        Connection con = null;
        try {
            
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM mluser WHERE id = '" + targetID + "' AND password = '" + password + "'");
            if (rs.next()) {
                mu.setId(rs.getString("id"));
                mu.setFname(rs.getString("fname"));
                mu.setLname(rs.getString("lname"));
                mu.setGender(rs.getString("gender"));
                mu.setPassword(rs.getString("password"));
                mu.setPosition(rs.getString("position"));
                mu.setStatus(rs.getString("status"));
                
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Userfunc.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
           
        }
         return mu;
    }
    
    public List<MLuser> getAllAgent() {
        ArrayList<MLuser> AS = new ArrayList();
        Connection con = null;
        try {
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM mluser");
            while (rs.next()) {
                MLuser mu = new MLuser();
                mu.setId(rs.getString("id"));
                mu.setFname(rs.getString("fname"));
                mu.setLname(rs.getString("lname"));
                mu.setGender(rs.getString("gender"));
                mu.setPassword(rs.getString("password"));
                mu.setPosition(rs.getString("position"));
                mu.setStatus(rs.getString("status"));
                AS.add(mu);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Userfunc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return AS;
    }

}
