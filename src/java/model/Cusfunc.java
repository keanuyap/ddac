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
public class Cusfunc {

    public Cusfunc() {
    }

    public void registerCus(MLcustomer u) {
        Connection con = null;
        try {
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("insert into mlcustomer values ('" + u.getId() + "','" + u.getAddress() + "','" + u.getCname()  + "','" + u.getGender() + "')");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Cusfunc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public MLcustomer searchCus(String targetID) {
        MLcustomer mu = new MLcustomer();
        Connection con = null;
        try {
            
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM mlcustomer WHERE id = '" + targetID + "'");
            if (rs.next()) {
                mu.setId(rs.getString("id"));
                mu.setGender(rs.getString("gender"));
                mu.setAddress(rs.getString("address"));
                mu.setCname(rs.getString("cname"));
                
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Cusfunc.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
           
        }
         return mu;
    }
    
        public List<MLcustomer> getAllCustomer() {
        ArrayList<MLcustomer> AS = new ArrayList();
        Connection con = null;
        try {
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM mlcustomer");
            while (rs.next()) {
                MLcustomer mu = new MLcustomer();
                mu.setId(rs.getString("id"));
                mu.setGender(rs.getString("gender"));
                mu.setAddress(rs.getString("address"));
                mu.setCname(rs.getString("cname"));
                AS.add(mu);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Cusfunc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return AS;
    }
}
