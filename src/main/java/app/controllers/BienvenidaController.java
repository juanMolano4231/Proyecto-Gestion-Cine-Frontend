/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.controllers;

import app.frames.FrameBienvenida;
import app.services.BienvenidaService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Juan Jose Molano Franco
 */
public class BienvenidaController {
    
    private final BienvenidaService service;
    
    public BienvenidaController() {
        this.service = new BienvenidaService();
    }
    
    public String bienvenida() {
        int seleccion = levantarFrameBienvenida();
        return service.bienvenida(seleccion);
    }

    private int levantarFrameBienvenida() {
        FrameBienvenida frame = new FrameBienvenida();
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
}
