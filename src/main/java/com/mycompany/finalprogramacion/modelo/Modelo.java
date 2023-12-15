/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogramacion.modelo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Modelo {

    Connection con = null;
    ResultSet rs = null;
    Statement stmt = null;

    String url = "localhost:3306";
    String dbName = "tabla";

    private static final String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private String urlRoot;
    private static Modelo m;

    //informacion
    //Busquedas
    private ActionListener listener;

    public Modelo() {
        urlRoot = getRootUrl(url);
        listener = null;

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {

            reportException(e.getMessage());
        }
    }

    private static String getRootUrl(String url) {
        return "jdbc:mysql://" + url + "/";
    }

    public static Modelo getInstance() {
        if (m == null) {
            m = new Modelo();
        }
        return m;
    }

    public Modelo getModelo() {
        return m;
    }

    public Boolean login(String nomb, String pass) {

        Boolean respuesta = false;

        try {
            con = DriverManager.getConnection(urlRoot + dbName + "?useSSL=false", "root", "root");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM usu");

            while (rs.next() && respuesta != true) {

                if (rs.getString("usuario").equals(nomb) && rs.getString("clave").equals(pass)) {
                    respuesta = true;
                }

            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return respuesta;
    }
    
    public void CreateContribuyente(String usuario, String clave, int dni, String mail, int telefono, String nombre, String apellido) {
        this.CreateUsuario(usuario, clave, "contribuyente", dni, mail, telefono, nombre, apellido);
    }

    private void CreateUsuario(String usuario, String clave, String rol, int dni, String mail, int telefono, String nombre, String apellido) {
        try {
            con = DriverManager.getConnection(urlRoot + dbName + "?useSSL=false", "root", "root");
            stmt = con.createStatement();
            
            String insert = String.format("INSERT INTO usu (usuario, clave, rol, dni, mail, telefono, nombre, apellido)"
                    + " VALUES ( '%s' , '%s' , '%s' , '%d' , '%s', '%d', '%s', '%s');", 
                    usuario, clave, rol, dni, mail, telefono, nombre, apellido );
                    System.out.println("inserting: " + insert);
            
            
            stmt.execute(insert);
            
            

            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public Usuario getUsuario(String usuario) {

        Usuario user = null;

        try {
            con = DriverManager.getConnection(urlRoot + dbName + "?useSSL=false", "root", "root");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM usu WHERE usuario ='" + usuario + "'");

            rs.next();
            // int id, String usuario, String clave, String rol, int dni, String mail, int telefono, String nombre, String apellido

            user = Factory.creaUsu(rs.getInt("idUsuario"),
                    rs.getString("usuario"),
                    rs.getString("clave"),
                    rs.getString("rol"),
                    rs.getInt("dni"),
                    rs.getString("mail"),
                    rs.getInt("telefono"),
                    rs.getString("nombre"),
                    rs.getString("apellido"));

            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return user;

    }

    public List<Reclamo> getReclamos(Usuario p) {
        List<Reclamo> lista = new ArrayList<>();

        try {
            con = DriverManager.getConnection(urlRoot + dbName + "?useSSL=false", "root", "root");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            rs = stmt.executeQuery(p.getLista());
            rs.beforeFirst();

            while (rs.next()) {
                lista.add(new Reclamo(rs.getInt("idReclamo"), rs.getString("descripcion"), rs.getDate("fecha"), Categorias.valueOf(rs.getString("categoria")), rs.getString("domicilio")));
            }

            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return lista;

    }

// excepciones
    // excepcion 
    private void reportException(String exception) {
        if (listener != null) {
            ActionEvent evt = new ActionEvent(this, 0, exception);
            listener.actionPerformed(evt);
        }
    }

    public void addExceptionListener(ActionListener listener) {
        this.listener = listener;
    }

}
