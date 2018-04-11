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
import model.MLuser;
import model.Userfunc;

/**
 *
 * @author th3-k
 */
public class RegisterAgent extends HttpServlet {

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
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String position = request.getParameter("position");
        String gender = request.getParameter("gender");
        String status = request.getParameter("status");
        Userfunc uf = new Userfunc();
        MLuser ul = new MLuser();
        MLuser u = new MLuser(id, password, fname, lname, position, gender, status);
        try (PrintWriter out = response.getWriter()) {

            ul = uf.searchAgent(id);
            if (ul.getId()!=null) {
                out.println("Username has been used.");
                request.getRequestDispatcher("register.jsp").include(request, response);
            } else {
                if (password.equals(repassword)) {
                    uf.registerAgent(u);
                    out.println("Register Successfully");
                    request.getRequestDispatcher("Admin.jsp").include(request, response);
                } else {
                    out.println("Password does not match.");
                    request.getRequestDispatcher("register.jsp").include(request, response);
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
