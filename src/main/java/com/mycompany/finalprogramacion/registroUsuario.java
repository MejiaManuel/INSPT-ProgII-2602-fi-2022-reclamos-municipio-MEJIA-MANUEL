/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.finalprogramacion;

import com.mycompany.finalprogramacion.modelo.Modelo;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
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
@WebServlet(name = "registroUsuario", urlPatterns = {"/registroUsuario"})
public class registroUsuario extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //usuario, clave, rol, dni, mail, telefono, nombre, apellido
    
        Modelo m = new Modelo();
        
        m.CreateContribuyente(request.getParameter("usuario"),
        request.getParameter("clave"),
        Integer.valueOf( request.getParameter("dni")),
        request.getParameter("mail"),
        Integer.valueOf(request.getParameter("telefono")),
        request.getParameter("nombre"),
        request.getParameter("apellido"));
        
        processRequest(request, response);
        
        response.sendRedirect("/Finalprog2");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
