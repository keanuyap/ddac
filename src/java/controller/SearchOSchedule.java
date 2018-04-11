/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Itemfunc;
import model.MLitem;
import model.MLschedule;
import model.Schedulefunc;

/**
 *
 * @author th3-k
 */
public class SearchOSchedule extends HttpServlet {

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
            HttpSession s = request.getSession(false);
            String button = request.getParameter("button");

            Itemfunc itf = new Itemfunc();
            Schedulefunc scf = new Schedulefunc();
            List<MLschedule> m = scf.getAllSchedule();
            List<MLitem> mi = itf.getAllItem();
            List<String> a = new ArrayList();
            List<String> b = new ArrayList();
            List<MLschedule> Oresult = new ArrayList();

            if (button.equals("ShowAll")) {
                for (int i = 0; i < m.size(); i++) {
                    MLschedule M = m.get(i);
                    if (M.getStatus().equals("Open")) {
                        Oresult.add(M);
                    }
                }
                s.setAttribute("Oresult", Oresult);
                request.getRequestDispatcher("searchOSchedule.jsp").include(request, response);
            } else if (button.equals("makebooking")) {
                if (m == null) {
                    out.println("There are no available schedule.");
                    s.setAttribute("Oresult", Oresult);
                    request.getRequestDispatcher("searchOSchedule.jsp").include(request, response);
                } else {
                    for (int i = 0; i < mi.size(); i++) {
                        a.add(mi.get(i).getId());
                    }
                    for (int i = 0; i < m.size(); i++) {
                        if (m.get(i).getStatus().equals("Open")) {
                            b.add(m.get(i).getId());
                        }

                    }
                    s.setAttribute("a", a);
                    s.setAttribute("b", b);
                    request.getRequestDispatcher("makebooking.jsp").forward(request, response);
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
