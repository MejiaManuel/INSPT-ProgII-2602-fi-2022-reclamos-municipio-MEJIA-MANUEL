/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.finalprogramacion;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Manu
 */
@WebServlet(name = "RegistroServlet", urlPatterns = {"/usuario"})
public class RegistroServlet extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String nombre = request.getParameter("nom");
            String apellido = request.getParameter("ape");
            PrintWriter out = response.getWriter();
            out.println("<html>hola " +nombre + " " + apellido + "</html>");
      
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
