/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.controllers;

import app.frames.FrameGestionFuncion;
import app.models.Funcion;
import app.models.Sala;
import app.services.GestionFuncionService;
import app.views.ViewGestionFuncion;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan José Molano Franco
 */
public class GestionFuncionController {
    
    private final GestionFuncionService service;
    private final ViewGestionFuncion view;

    public GestionFuncionController() {
        this.service = new GestionFuncionService();
        view = new ViewGestionFuncion();
    }
    
    public String gestionFuncion(Funcion funcion) {
        int seleccion = levantarFrameGestionFuncion(funcion);
        return service.gestionFuncion(seleccion, funcion);
    }
    
    public String exitoAlBorrar(Sala sala, Funcion funcion) {
        Sala salaActualizada = service.reloadSala(sala);
        try {
            service.borrarFuncion(salaActualizada, funcion);
        } catch (Exception ex) {
            notificar(ex.getMessage());
            return "GestionFuncion_gestionFuncion";
        }
        return service.exitoAlBorrar();
    }
    
    public String falloAlBorrar() {
        int seleccion = view.falloAlBorrar();
        return service.falloAlBorrar(seleccion);
    }

    private int levantarFrameGestionFuncion(Funcion funcion) {
        FrameGestionFuncion frame = new FrameGestionFuncion(funcion);
        frame.setVisible(true);

        /* Este ciclo revisa cada 250ms si el usuario ya clickeó un botón.
        En caso de que no espera otros 250ms, pero si sí entonces retorna la selección */
        while (true) {
            int seleccion = frame.getSeleccion();
            switch (seleccion) {
                case -1:  // Valor default, preferiblemente un número negativo
                    // Detiene el ciclo por 250 ms
                    try {
                        TimeUnit.MILLISECONDS.sleep(250);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                default:
                    frame.dispose();
                    return seleccion;
            }
        }
    }
    
    private void notificar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
