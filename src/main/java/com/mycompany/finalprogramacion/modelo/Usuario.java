/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogramacion.modelo;

/**
 *
 * @author Manu
 */
public abstract class Usuario {
    
    private int id;
    private final String nomb;
    private final String clave;


    public Usuario(int id, String nomb, String clave) {
        this.id = id;
        this.nomb = nomb;
        this.clave = clave;
    }

    public Usuario(String nomb, String clave) {
        this.nomb = nomb;
        this.clave = clave;
    }
 

    public int getId() {
        return id;
    }

    public String getNomb() {
        return nomb;
    }

    public String getClave() {
        return clave;
    }

    public abstract String getVista();
    
    public abstract String getLista();
    
    }




