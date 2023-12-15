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
    private final String usuario;
    private final String clave;
    private final String rol;
    private final int dni;
    private final String mail;
    private final int telefono;
    private final String nombre;
    private final String apellido;

  public Usuario(int id, String usuario, String clave, String rol, int dni, String mail, int telefono, String nombre, String apellido) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
        this.dni = dni;
        this.mail = mail;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido = apellido;
    }
/*
    public Usuario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
*/
    public int getId() {
        return this.id;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getClave() {
        return this.clave;
    }

    public abstract String getVista();

    public abstract String getLista();

}
