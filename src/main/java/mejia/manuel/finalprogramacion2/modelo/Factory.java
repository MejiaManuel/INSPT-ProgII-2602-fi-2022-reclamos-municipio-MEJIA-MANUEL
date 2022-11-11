/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mejia.manuel.finalprogramacion2.modelo;

/**
 *
 * @author Manu
 */
public class Factory {
    
    static public Usuario creaUsu(String rol, int id, String nomb, String clave){
    
    Usuario respuesta = null;
    
           switch (rol) {
            case "contribuyente":
                respuesta = new Contribuyente(id, nomb, clave);
                break;
            case "admin":
                respuesta = new Admin(id, nomb, clave);
                break;
        }

    return respuesta;
}
    
}
