/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogramacion.modelo;

/**
 *
 * @author Manu
 */
public class Usuario {
    
    private int id;
    private String nomb;
    private String clave;
    private Boolean admin;

    public Usuario(int id, String nomb, String clave, Boolean admin) {
        this.id = id;
        this.nomb = nomb;
        this.clave = clave;
        this.admin = admin;
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

    public Boolean getAdmin() {
        return admin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    
    
}
