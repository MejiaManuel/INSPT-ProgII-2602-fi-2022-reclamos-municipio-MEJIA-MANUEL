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

    private String jdbcDriver;
    private String dbName;
    private String urlRoot;
    private static Modelo m;

    //informacion
    //Busquedas
    private ActionListener listener;
       
    public Modelo(String url, String dbName) {
        jdbcDriver = "com.mysql.cj.jdbc.Driver";
        urlRoot = "jdbc:mysql://" + url + "/";
        this.dbName = dbName;
        listener = null;

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {

            reportException(e.getMessage());
        }
    }

    public static Modelo getInstance(String url, String dbName) {
        if (m == null) {
            m = new Modelo(url, dbName);
        }
        return m;
    }

    public Modelo getModelo() {
        return m;
    }
    
    
 
    public List<Reclamo> getReclamos()
    { 
        Reclamo rec;
        List<Reclamo> lista;
        lista = new ArrayList<>();
       
        try{
            con = DriverManager.getConnection(urlRoot + dbName + "?useSSL=false", "root", "root");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM recla");
            
            while (rs.next()){
                rec = new Reclamo(rs.getInt("idReclamo"), rs.getString("descripcion"));
                          
                lista.add(rec);
                
            }
        }catch(SQLException e){
            System.out.println(e);
        }
 
    /*lista.add(new Reclamo(1,"arbol caido"));
    lista.add(new Reclamo(2,"arbol ilegal"));
    lista.add(new Reclamo(3,"auto abandonado"));
    lista.add(new Reclamo(4,"Cambio de baldosas"));
    lista.add(new Reclamo(5,"mi vecino es molesto"));
        System.out.println("PIJA 1");*/
            
        System.out.println(lista);
    
    
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

    

