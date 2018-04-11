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
 * @author th3-k
 */
public class Shipfunc {

    public Shipfunc() {
    }

    public void registerShip(MLship u) {
        Connection con = null;
        try {
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("insert into mlship values ('" + u.getId() + "','" + u.getCapacity() + "','" + u.getSname() + "','" + u.getStatus() + "')");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Shipfunc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public MLship searchShip(String targetID) {
        MLship ms = new MLship();
        Connection con = null;
        try {
            
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM mlship WHERE id = '" + targetID + "'");
            if (rs.next()) {
                ms.setId(rs.getString("id"));
                ms.setCapacity(rs.getDouble("capacity"));
                ms.setSname(rs.getString("sname"));
                ms.setStatus(rs.getString("status"));
                
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Shipfunc.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
           
        }
         return ms;
    }
    
    public List<MLship> getAllShip() {
        ArrayList<MLship> AS = new ArrayList();
        Connection con = null;
        try {
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM mlship");
            while (rs.next()) {
                MLship A1 = new MLship();
                A1.setId(rs.getString("id"));
                A1.setCapacity(rs.getDouble("capacity"));
                A1.setSname(rs.getString("sname"));
                A1.setStatus(rs.getString("status"));
                AS.add(A1);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Shipfunc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return AS;
    }
}
