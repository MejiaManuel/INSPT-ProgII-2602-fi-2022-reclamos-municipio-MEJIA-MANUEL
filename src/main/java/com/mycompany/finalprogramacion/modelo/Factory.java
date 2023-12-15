/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogramacion.modelo;

/**
 *
 * @author Manu
 */
public class Factory {
    
    static public Usuario creaUsu(int id, String usuario, String clave, String rol, int dni, String mail, int telefono, String nombre, String apellido){
    
    Usuario respuesta = null;
    
           switch (rol) {
            case "contribuyente":
                respuesta = new Contribuyente(id, usuario, clave, rol, dni, mail, telefono, nombre, apellido);
                break;
            case "admin":
                respuesta = new Admin(id, usuario, clave, rol, dni, mail, telefono, nombre, apellido);
                break;
        }

    return respuesta;
}
    
}
