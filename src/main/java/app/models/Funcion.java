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
    
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private List<Boolean> asientos = new ArrayList<>();
    private String titulo;

    public Funcion(LocalDateTime inicio, LocalDateTime fin, String titulo) {
        this.inicio = inicio;
        this.fin = fin;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Funcion{" + "inicio=" + inicio + ", fin=" + fin + ", asientos=" + asientos + ", titulo=" + titulo + '}';
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
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

   

}

