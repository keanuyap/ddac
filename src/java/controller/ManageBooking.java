/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bookingfunc;
import model.Itemfunc;
import model.MLbooking;
import model.MLitem;
import model.MLschedule;
import model.Schedulefunc;

/**
 *
 * @author th3-k
 */
public class ManageBooking extends HttpServlet {

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
        String button = request.getParameter("button");
        String bid = request.getParameter("id");
        String scid = request.getParameter("scid");
        String iid = request.getParameter("iid");
        String status = request.getParameter("status");

        Bookingfunc bf = new Bookingfunc();
        Schedulefunc scf = new Schedulefunc();
        Itemfunc itf = new Itemfunc();
        MLbooking mb = bf.searchBooking(bid);
        MLschedule Scid = scf.searchSchedule(scid);
        MLitem Iid = itf.searchItem(iid);
        Double iw = Iid.getWeight();
        Double scw = Scid.getAcapacity();
        Double lw = scw - iw;

        try (PrintWriter out = response.getWriter()) {
            if (button.equals("Confirm")) {

                bf.editBooking(bid, status);
                if (status.equals("Approve")) {
                    scf.editSchedule(scid, lw);
                    MLschedule SCid = scf.searchSchedule(scid);
                    if (SCid.getAcapacity() <= 0) {
                        scf.editScheduleStatus(scid);
                    }
                }
                out.println("The booking has been updated successfully.");
                request.getRequestDispatcher("Admin.jsp").include(request, response);
            }
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
