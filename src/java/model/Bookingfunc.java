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
public class Bookingfunc {

    public Bookingfunc() {
    }

    public void makeBooking(MLbooking u) {

        Connection con = null;
        try {
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("insert into mlbooking values ('" + u.getId() + "','" + u.getStatus() + "','" + u.getIid().getId() + "','" + u.getScid().getId() + "','" + u.getUid().getId() + "')");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Bookingfunc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public MLbooking searchBooking(String targetID) {
        MLbooking mb = new MLbooking();
        MLitem mi = new MLitem();
        MLschedule ms = new MLschedule();
        MLuser mu = new MLuser();
        Connection con = null;
        try {

            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM mlbooking WHERE id = '" + targetID + "'");
            if (rs.next()) {
                mb.setId(rs.getString("id"));
                mb.setStatus(rs.getString("status"));
                ResultSet rc = st.executeQuery("SELECT * FROM mlbooking WHERE id = '" + rs.getString("iid") + "'");
                mi.setId(rc.getString("id"));
                mb.setIid(mi);
                ResultSet rb = st.executeQuery("SELECT * FROM mlbooking WHERE id = '" + rs.getString("scid") + "'");
                ms.setId(rb.getString("id"));
                mb.setScid(ms);
                ResultSet ra = st.executeQuery("SELECT * FROM mlbooking WHERE id = '" + rs.getString("uid") + "'");
                mu.setId(ra.getString("id"));
                mb.setUid(mu);

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Bookingfunc.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
        return mb;
    }

    public List<MLbooking> getAllBooking() {
        ArrayList<MLbooking> AS = new ArrayList();
        ArrayList<MLbooking> AF = new ArrayList();
        Connection con = null;
        try {
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement st = con.createStatement();
            Statement sl = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM mlbooking");

            while (rs.next()) {
                MLbooking mb = new MLbooking();
                MLitem mi = new MLitem();
                MLschedule ms = new MLschedule();
                MLuser mu = new MLuser();

                mb.setId(rs.getString("id"));
                mb.setStatus(rs.getString("status"));

                mi.setId(rs.getString("iid"));
                mb.setIid(mi);

                ms.setId(rs.getString("scid"));
                mb.setScid(ms);

                mu.setId(rs.getString("uid"));
                mb.setUid(mu);

                AS.add(mb);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Bookingfunc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return AS;
    }

    public void editBooking(String bid, String status) {

        Connection con = null;
        try {
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE mlbooking SET status = '" + status + "' WHERE id = '" + bid + "' ");

        } catch (Exception e) {

            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Bookingfunc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
