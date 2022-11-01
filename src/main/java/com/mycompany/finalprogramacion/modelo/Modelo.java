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
    
    String url= "localhost:3306";
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
    
    public Boolean login(String nomb, String pass){
    
        Boolean respuesta = false;
        
    try{
            con = DriverManager.getConnection(urlRoot + dbName + "?useSSL=false", "root", "root");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM usu");
            
            while (rs.next()){
                
                if ( rs.getString("usuario").equals(nomb) && rs.getString("clave").equals(pass)){
                    respuesta = true;
                }
                
            }
            con.close();
        }catch(SQLException e){
            System.out.println(e);
        }  
        
        
        return respuesta;
    }
    
    public Usuario getUsuario(String nomb){
        
        /*
        Roles: Contributenye = 0; Admin = 1;
        */
        
        Usuario respuesta = null;
        int id = 0;
        String clave = "";
        int rol = 0;

        try {
            con = DriverManager.getConnection(urlRoot + dbName + "?useSSL=false", "root", "root");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM usu WHERE usuario ='" + nomb + "'");

            while (rs.next()) {
                id = rs.getInt("idUsuario");
                clave = rs.getString("clave");
                rol = rs.getInt("rol");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        switch (rol) {
            case 0:
                respuesta = new Contribuyente(id, nomb, clave);
                break;
            case 1:
                respuesta = new Admin(id, nomb, clave);
                break;
        }

        return respuesta;

    }

    
    public List<Reclamo> getReclamos(Usuario p)
    { 
        List<Reclamo> lista = new ArrayList<>();
        int rol = Integer.MAX_VALUE;
        
       
        try{
            con = DriverManager.getConnection(urlRoot + dbName + "?useSSL=false", "root", "root");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM usu WHERE idUsuario ='" + p.getId() + "'");
            
            while (rs.next()){
            rol = rs.getInt("rol");
            }
            
            rs = stmt.executeQuery("SELECT * FROM recla");
            rs.beforeFirst();
           
            switch (rol) {
                case 0:
                    while (rs.next()) {
                        if (p.getId() == rs.getInt("usu_idUsuario"))  
                            lista.add(new Reclamo(rs.getInt("idReclamo"), rs.getString("descripcion"), rs.getDate("fecha"),Categorias.valueOf(rs.getString("categoria")),rs.getString("domicilio")));
                    }

                    break;
                case 1:
                    while (rs.next()) {
                        lista.add(new Reclamo(rs.getInt("idReclamo"), rs.getString("descripcion"), rs.getDate("fecha"),Categorias.valueOf(rs.getString("categoria")),rs.getString("domicilio")));
                    }
                    break;
                default:
                    break;
            }

            con.close();
        }catch(SQLException e){
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

    

