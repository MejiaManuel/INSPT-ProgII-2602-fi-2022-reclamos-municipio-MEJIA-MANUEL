/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.finalprogramacion;

import com.mycompany.finalprogramacion.modelo.Modelo;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashSet;

/**
 *
 * @author Manu
 */
@WebServlet(name = "ReclamosServlet", urlPatterns = {"/reclamos"})
public class ReclamosServlet extends HttpServlet {

   private final String URI_LIST = "/pages/vistaReclamos.jsp";
        HttpServletRequest request;
        HttpServletResponse response;
                
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            this.request = request;
            this.response = response;
            String ip = request.getParameter("dirIP");
            String bd = request.getParameter("nomBD");
            Modelo m = new Modelo(ip, bd);
            m.getReclamos();
            
        

        
        request.setAttribute("listaReclamos", m.getReclamos());
        
        
        
        request.getRequestDispatcher(URI_LIST).forward(request, response);
        

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
