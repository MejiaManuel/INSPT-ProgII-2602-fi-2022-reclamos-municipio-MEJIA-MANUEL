/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogramacion.modelo;

/**
 *
 * @author manue
 */
public class Admin extends Usuario{

    public Admin(int id, String nomb, String clave) {
        super(id, nomb, clave);
    }
    
    @Override
        public String getVista(){
            return "/pages/vistaReclamos.jsp";
        }
    
}
