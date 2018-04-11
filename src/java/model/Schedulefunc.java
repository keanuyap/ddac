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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author th3-k
 */
public class Schedulefunc {

    public Schedulefunc() {
    }

    public void registerSchedule(MLschedule u) {
     
        Connection con = null;
        try {
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement ps = con.createStatement();
            ps.executeUpdate("insert into mlschedule values ('" + u.getId() + "','" + u.getADate() + "','" + u.getDDate() + "','" + u.getAcapacity() + "','" + u.getArrival() + "','" + u.getDeparture() + "','" + u.getStatus() + "','" + u.getSid().getId() + "')");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Schedulefunc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public MLschedule searchSchedule(String targetID) {
        MLschedule mu = new MLschedule();
        MLship mc = new MLship();
        Connection con = null;
        try {

            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM mlschedule WHERE id = '" + targetID + "'");
            if (rs.next()) {
                mu.setId(rs.getString("id"));
                mu.setADate(rs.getString("adate"));
                mu.setDDate(rs.getString("ddate"));
                mu.setAcapacity(rs.getDouble("acapacity"));
                mu.setArrival(rs.getString("arrival"));
                mu.setDeparture(rs.getString("departure"));
                mu.setStatus(rs.getString("status"));
                ResultSet rc = st.executeQuery("SELECT * FROM mlship WHERE id = '" + rs.getString("sid") + "'");
                mc.setId(rc.getString("id"));
                mu.setSid(mc);

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Schedulefunc.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
        return mu;
    }

    public List<MLschedule> getAllSchedule() {
        ArrayList<MLschedule> AS = new ArrayList();
        Connection con = null;
        try {
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM mlschedule");
            while (rs.next()) {
                MLschedule A1 = new MLschedule();
                MLship ms = new MLship();
                A1.setId(rs.getString("id"));
                A1.setADate(rs.getString("adate"));
                A1.setDDate(rs.getString("ddate"));
                A1.setAcapacity(rs.getDouble("acapacity"));
                A1.setArrival(rs.getString("arrival"));
                A1.setDeparture(rs.getString("departure"));
                A1.setStatus(rs.getString("status"));
                ms.setId(rs.getString("sid"));
                A1.setSid(ms);
                AS.add(A1);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Schedulefunc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return AS;
    }
    
    public void editSchedule(String scid, double acapacity) {

        Connection con = null;
        try {
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE mlschedule SET acapacity = '" + acapacity + "' WHERE id = '" + scid + "' ");

        } catch (Exception e) {

            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Schedulefunc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
    
    public void editScheduleStatus(String scid) {

        Connection con = null;
        try {
            DB_Connection dbcon = new DB_Connection();
            con = dbcon.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE mlschedule SET status = 'Closed' WHERE id = '" + scid + "' ");

        } catch (Exception e) {

            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Schedulefunc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
