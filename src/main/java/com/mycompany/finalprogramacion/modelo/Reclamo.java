/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogramacion.modelo;

import java.util.Date;



/**
 *Tendrán un ID único, la fecha en que se creó y la fecha en que se resolvió (esta
última puede no existir si aún no se ha resuelto), la categoría (alumbrado, arbolado, limpieza,
pluvial) y el domicilio del inmueble sobre afectado.
 */
public class Reclamo {
    
    private String descripcion;
    private Categorias categoria;
    private String domicilio;

    public Categorias getCategoria() {
        return categoria;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public Date getFecha() {
        return fecha;
    }
    private int id;
    private Date fecha;

    public Reclamo() {
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public static Reclamo getInstance(){
        return new Reclamo();
    }

    public Reclamo( int id, String descripcion) {
        this.descripcion = descripcion;
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getId() {
        return id;
    }
    
    
    
}
