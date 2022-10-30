/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.finalprogramacion;

import com.mycompany.finalprogramacion.modelo.Modelo;
import com.mycompany.finalprogramacion.modelo.Usuario;
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
@WebServlet(name = "Parcial2", urlPatterns = {"/Parcial2"})
public class Parcial2 extends HttpServlet {

    public Usuario colega;
    private final String URI_LIST = "/pages/inicioSesion.jsp";
    HttpServletRequest request;
     HttpServletResponse response;
           
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        request.getRequestDispatcher(URI_LIST).forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
                this.request = request;
        this.response = response;
        String ip = "localhost:3306";
        // request.getParameter("dirIP");
        String bd = "tabla";
        //request.getParameter("nomBD");
        Modelo m = new Modelo(ip, bd);
        
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        if(!m.login(user, pass)){
            response.sendError(response.SC_UNAUTHORIZED, "Usuario o clave incorrectas");
        }else{
           colega = m.getUsuario(user);
        }
        
        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
