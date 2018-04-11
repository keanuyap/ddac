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
import javax.servlet.http.HttpSession;
import model.Bookingfunc;
import model.Itemfunc;
import model.MLbooking;
import model.MLitem;
import model.MLschedule;
import model.MLuser;
import model.Schedulefunc;
import model.Userfunc;

/**
 *
 * @author th3-k
 */
public class MakeBooking extends HttpServlet {

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
        String bid = request.getParameter("bid");
        String iid = request.getParameter("iid");
        String scid = request.getParameter("scid");
        String status = request.getParameter("status");

        Itemfunc itf = new Itemfunc();
        Schedulefunc scf = new Schedulefunc();
        Userfunc uf = new Userfunc();
        MLitem Iid = itf.searchItem(iid);
        MLschedule Scid = scf.searchSchedule(scid);
        HttpSession s = request.getSession(false);
        MLuser e = (MLuser) s.getAttribute("MLuser");
        String uid = e.getId();
        MLuser Uid = uf.searchAgent(uid);
        Double iw = Iid.getWeight();
        Double scw = Scid.getAcapacity();

        Bookingfunc bf = new Bookingfunc();
        MLbooking mb = new MLbooking();
        MLbooking mk = new MLbooking(bid, Scid, Iid, Uid, status);

        try (PrintWriter out = response.getWriter()) {
            mb = bf.searchBooking(bid);
            if (mb.getId()!=null) {
                out.println("The Booking Id has been used");
                request.getRequestDispatcher("searchOSchedule.jsp").include(request, response);
            } else {
                if (scw >= iw) {
                    bf.makeBooking(mk);
                    out.println("Make Booking Successfully");
                    request.getRequestDispatcher("Agent.jsp").include(request, response);
                } else {
                    out.println("The Ship is overload");
                    request.getRequestDispatcher("searchOSchedule.jsp").include(request, response);
                }
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
