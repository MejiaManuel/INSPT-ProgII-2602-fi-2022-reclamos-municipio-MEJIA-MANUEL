/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogramacion.modelo;

import java.util.Date;

/**
 * Tendrán un ID único, la fecha en que se creó y la fecha en que se resolvió
 * (esta última puede no existir si aún no se ha resuelto), la categoría
 * (alumbrado, arbolado, limpieza, pluvial) y el domicilio del inmueble sobre
 * afectado.
 */
public class Reclamo {

    private int id;
    private String descripcion;
    private Date fecha;
    private Categorias categoria;
    private String domicilio;

    public Reclamo(int id, String descripcion, Date fecha, int cate, String domicilio) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.domicilio = domicilio;
        setCategoria(cate);
    }

    private void setCategoria(int i) {

        switch (i) {
            case 0:
                categoria = Categorias.ALUMBRADO;
                break;
            case 1:
                categoria = Categorias.ARBOLADO;
                break;
            case 2:
                categoria = Categorias.LIMPIEZA;
                break;
            case 3:
                categoria = Categorias.PLUBIAL;
                break;
            default:
                categoria = null;
        }

    }

    
    public Categorias getCategoria() {
        return categoria;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getId() {
        return id;
    }

}
