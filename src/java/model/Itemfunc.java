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
public class Itemfunc {

    public Itemfunc() {
    }

    public void registerItem(MLitem u) {
        Connection con = null;
        try {
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("insert into mlitem values ('" + u.getId() + "','" + u.getIname() + "','" + u.getWeight() + "','" + u.getCid().getId() + "')");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Itemfunc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public MLitem searchItem(String targetID) {
        MLitem mu = new MLitem();
        MLcustomer mc = new MLcustomer();
        Connection con = null;
        try {

            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM mlitem WHERE id = '" + targetID + "'");
            if (rs.next()) {
                mu.setId(rs.getString("id"));
                mu.setIname(rs.getString("iname"));
                mu.setWeight(rs.getDouble("weight"));
                ResultSet rc = st.executeQuery("SELECT * FROM mlcustomer WHERE id = '" + rs.getString("cid") + "'");
                mc.setId(rc.getString("id"));
                mu.setCid(mc);

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Itemfunc.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
        return mu;
    }

    public List<MLitem> getAllItem() {
        ArrayList<MLitem> AS = new ArrayList();
        Connection con = null;
        try {
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM mlitem");
            while (rs.next()) {
                MLitem mu = new MLitem();
                MLcustomer mc = new MLcustomer();
                mu.setId(rs.getString("id"));
                mu.setIname(rs.getString("iname"));
                mu.setWeight(rs.getDouble("weight"));
                mc.setId(rs.getString("cid"));
                mu.setCid(mc);
                AS.add(mu);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Itemfunc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return AS;
    }
}
