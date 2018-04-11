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
import model.MLuser;
import model.Userfunc;

/**
 *
 * @author th3-k
 */
public class SearchAgent extends HttpServlet {

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
        String Akeyword = request.getParameter("Akeyword");
        String ACategories = request.getParameter("ACategories");

        Userfunc u = new Userfunc();
        List<MLuser> m = u.getAllAgent();
        List<MLuser> Aresult = new ArrayList();

        if (button.equals("ShowAll")) {

            for (int i = 0; i < m.size(); i++) {
                MLuser M = m.get(i);
                if (M.getPosition().equals("Agent")) {
                    Aresult.add(M);
                }

            }
        } else if (button.equals("Search")) {
            for (int i = 0; i < m.size(); i++) {
                MLuser M = m.get(i);
                if (ACategories.equals("id")) {
                    if (M.getId().equals(Akeyword)) {
                        if (M.getPosition().equals("Agent")) {
                            Aresult.add(M);
                        }
                    }
                } else if (ACategories.equals("fname")) {
                    if (M.getFname().equals(Akeyword)) {
                        if (M.getPosition().equals("Agent")) {
                            Aresult.add(M);
                        }
                    }
                } else if (ACategories.equals("lname")) {
                    if (M.getLname().equals(Akeyword)) {
                        if (M.getPosition().equals("Agent")) {
                            Aresult.add(M);
                        }
                    }
                } else if (ACategories.equals("gender")) {
                    if (M.getGender().equals(Akeyword)) {
                        if (M.getPosition().equals("Agent")) {
                            Aresult.add(M);
                        }
                    }
                } else if (ACategories.equals("position")) {
                    if (M.getPosition().equals(Akeyword)) {
                        if (M.getPosition().equals("Agent")) {
                            Aresult.add(M);
                        }
                    }
                } else if (ACategories.equals("status")) {
                    if (M.getStatus().equals(Akeyword)) {
                        if (M.getPosition().equals("Agent")) {
                            Aresult.add(M);
                        }
                    }
                }

            }
        }

        s.setAttribute("Aresult", Aresult);
        request.getRequestDispatcher("searchAgent.jsp").include(request, response);

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
