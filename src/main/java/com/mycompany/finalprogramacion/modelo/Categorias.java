/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.finalprogramacion.modelo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Manu
 */
public enum Categorias {
    ALUMBRADO(1),
    ARBOLADO(2),
    LIMPIEZA(3),
    PLUVIAL(4);

    private final int categoriaNumber;

    Categorias(int categoriaNumber) {
        this.categoriaNumber = categoriaNumber;
    }

    public int getCategoriaNumber() {
        return categoriaNumber;
    }
    
    public static Categorias getCategoriaByNumber(int number) {
        for (Categorias categoria : values()) {
            if (categoria.getCategoriaNumber() == number) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Invalid categoria number: " + number);
    }
    
}
