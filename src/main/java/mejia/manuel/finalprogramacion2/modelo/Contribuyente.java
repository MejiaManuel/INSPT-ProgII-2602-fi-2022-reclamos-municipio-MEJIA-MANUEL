/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mejia.manuel.finalprogramacion2.modelo;

/**
 *
 * @author manue
 */
public class Contribuyente extends Usuario{

    public Contribuyente(int id, String nomb, String clave) {
        super(id, nomb, clave);
    }
        
    @Override
    public String getVista(){
        return "/pages/vistaRecContri.jsp";
    }
    
    @Override
    public String getLista(){
        return "SELECT * FROM recla WHERE usu_idUsuario ='" + this.getId() + "'";
    }
    
}
