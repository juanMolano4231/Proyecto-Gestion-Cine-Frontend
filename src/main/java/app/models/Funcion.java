/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan José Molano Franco
 */
public class Funcion {
    
    private String inicio;
    private String fin;
    private List<Boolean> asientos = new ArrayList<>();
    private String titulo;

    public Funcion(String inicio, String fin, String titulo) {
        this.inicio = inicio;
        this.fin = fin;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Funcion{" + "inicio=" + inicio + ", fin=" + fin + ", asientos=" + asientos + ", titulo=" + titulo + '}';
    }

    public List<Boolean> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Boolean> asientos) {
        this.asientos = asientos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

   

}

