/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mejia.manuel.finalprogramacion2.controlador;

import mejia.manuel.finalprogramacion2.modelo.Modelo;
import mejia.manuel.finalprogramacion2.modelo.Usuario;
import jakarta.servlet.RequestDispatcher;
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
@WebServlet(name = "Parcial2", urlPatterns = {"/Parcial2"})
public class LoginServlet extends HttpServlet {

    private Usuario p;
    HttpServletRequest request;
    HttpServletResponse response;


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

        this.request = request;
        this.response = response;

        Modelo m = new Modelo();

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        if (!m.login(user, pass)) {
            response.sendError(response.SC_UNAUTHORIZED, "Usuario o clave incorrectas");
        } else {

            request.setAttribute("user", user);
            request.getSession().setAttribute("user", user);

            request.getRequestDispatcher("/pages/reclamos.jsp").forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
