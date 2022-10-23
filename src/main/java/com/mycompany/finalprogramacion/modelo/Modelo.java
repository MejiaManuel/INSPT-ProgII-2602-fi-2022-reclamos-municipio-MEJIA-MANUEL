/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogramacion.modelo;

import java.util.ArrayList;
import java.util.List;

public class Modelo {
    
  
    
    public List<Reclamo> getReclamos()
    {
    List<Reclamo> lista;
    lista = new ArrayList<>();
    
    lista.add(new Reclamo(1,"arbol caido"));
    lista.add(new Reclamo(2,"arbol ilegal"));
    lista.add(new Reclamo(3,"auto abandonado"));
    lista.add(new Reclamo(4,"Cambio de baldosas"));
    lista.add(new Reclamo(5,"mi vecino es molesto"));
    
    
    return lista;
    }
    
    
}
