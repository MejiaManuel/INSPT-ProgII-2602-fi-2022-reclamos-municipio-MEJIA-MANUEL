/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.finalprogramacion;

import com.mycompany.finalprogramacion.modelo.Categorias;
import com.mycompany.finalprogramacion.modelo.Modelo;
import com.mycompany.finalprogramacion.modelo.Usuario;
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
@WebServlet(name = "registroReclamo", urlPatterns = {"/registroReclamo"})
public class registroReclamo extends HttpServlet {

    Usuario p;

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
 
        
        Modelo m = new Modelo();
        
        
        // cree el reclamo
        
        m.createReclamo(request.getParameter("descripcion"),
        Categorias.getCategoriaByNumber(Integer.valueOf(request.getParameter("categoria"))),
        request.getParameter("domicilio"),
        Integer.valueOf(request.getParameter("id")));
        
        
        // volvemos a mostrar la pagina
        
        p = m.getUsuarioById(Integer.valueOf(request.getParameter("id")));
        
        request.setAttribute( "user", p.getUsuario());
        request.setAttribute( "id", p.getId());
        
        request.setAttribute("listaReclamos", m.getReclamos(p));
        
        processRequest(request, response);
        
        request.getRequestDispatcher(p.getVista()).forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
