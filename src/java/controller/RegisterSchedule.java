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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MLschedule;
import model.MLship;
import model.Schedulefunc;
import model.Shipfunc;

/**
 *
 * @author th3-k
 */
public class RegisterSchedule extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String id = request.getParameter("id");
            String departure = request.getParameter("departure");
            String arrival = request.getParameter("arrival");
            String ddate = request.getParameter("ddate");
            String adate = request.getParameter("adate");
            String sid = request.getParameter("sid");
            String status = request.getParameter("status");
            Shipfunc sf = new Shipfunc();
            Schedulefunc scf = new Schedulefunc();
            Double cap = sf.searchShip(sid).getCapacity();
            MLship Sid = new MLship();
            Sid = sf.searchShip(sid);
            MLschedule mc = new MLschedule();
            MLschedule mk = new MLschedule(id, ddate, adate, Sid, cap, departure, arrival, status);
            mc = scf.searchSchedule(id);

            if (mc.getId()!=null) {
                out.println("Schedule id has been used.");
                request.getRequestDispatcher("registerschedule.jsp").include(request, response);
            } else {
                scf.registerSchedule(mk);
                out.println("Register Schedule Successfully");
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
