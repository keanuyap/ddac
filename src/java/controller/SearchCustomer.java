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
import model.Cusfunc;
import model.MLcustomer;

/**
 *
 * @author th3-k
 */
public class SearchCustomer extends HttpServlet {

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
        HttpSession s = request.getSession(false);
        String button = request.getParameter("button");
        String Ckeyword = request.getParameter("Ckeyword");
        String CCategories = request.getParameter("CCategories");

        Cusfunc c = new Cusfunc();
        List<MLcustomer> m = c.getAllCustomer();
        List<MLcustomer> Cresult = new ArrayList();

        if (button.equals("ShowAll")) {

            for (int i = 0; i < m.size(); i++) {
                MLcustomer M = m.get(i);
                Cresult.add(M);
            }
        } else if (button.equals("Search")) {
            for (int i = 0; i < m.size(); i++) {
                MLcustomer M = m.get(i);
                if (CCategories.equals("id")) {
                    if (M.getId().equals(Ckeyword)) {
                        Cresult.add(M);
                    }
                } else if (CCategories.equals("cname")) {
                    if (M.getCname().equals(Ckeyword)) {
                        Cresult.add(M);
                    }
                } else if (CCategories.equals("address")) {
                    if (M.getAddress().equals(Ckeyword)) {
                        Cresult.add(M);
                    }
                } else if (CCategories.equals("gender")) {
                    if (M.getGender().equals(Ckeyword)) {
                        Cresult.add(M);
                    }
                }
            }
        }

        s.setAttribute("Cresult", Cresult);
        request.getRequestDispatcher("searchCustomer.jsp").include(request, response);
        try (PrintWriter out = response.getWriter()) {
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
