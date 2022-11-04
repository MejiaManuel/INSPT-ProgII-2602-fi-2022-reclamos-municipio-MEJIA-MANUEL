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
    
    static public Usuario creaUsu(int rol, int id, String nomb, String clave){
    
    Usuario respuesta = null;
    
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
    
}
