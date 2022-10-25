/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogramacion.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author manue
 */
public class Database {
    
    Connection conn = null;
    
    public Connection conexion(){
    String prefijoConexion = "jdbc:mysql://";
    String ip = "127.0.0.1"; 
    String usr = "root";
    String psw = "";
    String bd = "tabla";
    
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(prefijoConexion + ip + "/" + bd, usr, psw);
    }catch(Exception e){
        
        System.out.println(e + "el error fue en database");
    }
    
    return conn;
    }
    
    
}
