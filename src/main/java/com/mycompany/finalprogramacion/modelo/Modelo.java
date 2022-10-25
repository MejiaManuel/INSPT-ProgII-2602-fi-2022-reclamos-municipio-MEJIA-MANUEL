/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogramacion.modelo;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;


public class Modelo {
        
    Database database = new Database();
    Connection con = null;
    ResultSet rs = null;
    Statement stmt = null;
    
 
    public List<Reclamo> getReclamos()
    {
        
         List<Reclamo> lista;
         lista = new ArrayList<>();
        
        try{
            con = database.conexion();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM reclamos");
            while (rs.next()){
                
                int id = rs.getByte(1);
                String desc = rs.getString(2);
                
                lista.add(new Reclamo(id,desc));
                
            }
        }catch(SQLException e){
            System.out.println(e + "El error fue en modelo");
        }
        
    
    /*
 
    lista.add(new Reclamo(1,"arbol caido"));
    lista.add(new Reclamo(2,"arbol ilegal"));
    lista.add(new Reclamo(3,"auto abandonado"));
    lista.add(new Reclamo(4,"Cambio de baldosas"));
    lista.add(new Reclamo(5,"mi vecino es molesto"));
    
    */
    return lista;
    }
    
}
