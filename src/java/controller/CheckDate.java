/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.MLschedule;
import model.MLship;
import model.Schedulefunc;
import model.Shipfunc;

/**
 *
 * @author th3-k
 */
public class CheckDate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String ddate = request.getParameter("ddate");
        String adate = request.getParameter("adate");

        try (PrintWriter out = response.getWriter()) {
            Date Ddate = new SimpleDateFormat("yyyy-MM-dd").parse(ddate);
            Date Adate = new SimpleDateFormat("yyyy-MM-dd").parse(adate);

            if (Adate.compareTo(Ddate) <= 0) {
                out.println("Please Select Date Again.");
                request.getRequestDispatcher("registerschedule.jsp").include(request, response);
            } else {
                Schedulefunc scf = new Schedulefunc();
                Shipfunc sf = new Shipfunc();
                List<MLschedule> ml = scf.getAllSchedule();
                List<MLship> ms = sf.getAllShip();
                List<String> a = new ArrayList();
                List<String> b = new ArrayList();
                List<MLschedule> mc = new ArrayList();
                if (ml == null) {
                    for (int i = 0; i < ms.size(); i++) {
                        if (ms.get(i).getStatus().equals("Active")) {
                            a.add(ms.get(i).getId());
                        }
                    }
                } else {
                    for (int i = 0; i < ml.size(); i++) {
                        b.add(ml.get(i).getShipid());
                    }
                    for (int i = 0; i < ms.size(); i++) {
                        MLship MS = ms.get(i);
                        if (b.contains(MS.getId())) {
                            for (int x = 0; x < ml.size(); x++) {
                                MLschedule ML = ml.get(x);
                                if (ML.getShipid().equals(MS.getId())) {
                                    mc.add(ML);
                                }
                            }
                            int check = 0;
                            for (int c = 0; c < mc.size(); c++) {
                                MLschedule MLS = mc.get(c);
                                Date dd = new SimpleDateFormat("yyyy-MM-dd").parse(MLS.getDDate());
                                Date ad = new SimpleDateFormat("yyyy-MM-dd").parse(MLS.getADate());
                                if (!(dd.compareTo(Ddate) == 0) && !(ad.compareTo(Adate) == 0)) {
                                    if (((dd.compareTo(Adate) >= 0) && (ad.compareTo(Ddate) > 0)) || ((dd.compareTo(Adate) < 0) && (ad.compareTo(Ddate) <= 0))) {
                                        check = check + 1;
                                    }
                                }
                            }
                            if (check == mc.size()) {
                                if (ms.get(i).getStatus().equals("Active")) {
                                    a.add(MS.getId());
                                }
                            }
                            mc.clear();
                        } else {
                            if (ms.get(i).getStatus().equals("Active")) {
                                a.add(MS.getId());
                            }
                        }
                    }
                }
                HttpSession s = request.getSession(false);
                s.setAttribute("a", a);
                request.getRequestDispatcher("confirmship.jsp").include(request, response);
            }
        } catch (ParseException ex) {
            Logger.getLogger(CheckDate.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
