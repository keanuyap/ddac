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
import model.Cusfunc;
import model.Itemfunc;
import model.MLcustomer;
import model.MLitem;

/**
 *
 * @author th3-k
 */
public class RegisterItem extends HttpServlet {

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
        String iname = request.getParameter("iname");
        String cid = request.getParameter("cid");
        String weight = request.getParameter("weight");
        Double iweight = Double.parseDouble(weight);
        Itemfunc itf = new Itemfunc();
        Cusfunc cf = new Cusfunc();
        MLitem i = new MLitem();
        MLcustomer c = new MLcustomer();
        try (PrintWriter out = response.getWriter()) {
            i = itf.searchItem(id);
            c = cf.searchCus(cid);
            if (i.getId()!=null) {
                out.println("Item ID has been used.");
                request.getRequestDispatcher("registeritem.jsp").include(request, response);
            } else {
                if (c.getId().equals(cid)) {
                    MLitem u = new MLitem(id, iname, c, iweight);
                    itf.registerItem(u);
                    out.println("Register Item Successfully");
                    request.getRequestDispatcher("Agent.jsp").include(request, response);
                } else {
                    out.println("Please register the customer first.");
                    request.getRequestDispatcher("registeritem.jsp").include(request, response);
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
