/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogramacion.modelo;

/**
 *
 * @author manue
 */
public class Contribuyente extends Usuario {
    

    public Contribuyente(int id, String usuario, String clave, String rol, int dni, String mail, int telefono, String nombre, String apellido) {
        super(id, usuario, clave, rol, dni, mail, telefono, nombre, apellido);
    }

    @Override
    public String getVista() {
        return "/pages/vistaRecContri.jsp";
    }

    @Override
    public String getLista() {
        return "SELECT * FROM recla WHERE usu_idUsuario ='" + this.getId() + "'";
    }

}
