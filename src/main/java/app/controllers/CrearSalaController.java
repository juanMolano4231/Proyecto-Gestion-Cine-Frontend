/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.controllers;

import app.frames.FrameCrearSala;
import app.services.CrearSalaService;
import app.views.ViewCrearSala;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Juan José Molano Franco
 */
public class CrearSalaController {

    private final CrearSalaService service;
    private final ViewCrearSala crearSala;
    
    public CrearSalaController() {
        this.service = new CrearSalaService();
        crearSala = new ViewCrearSala();
    }
    
    public Object[] crearSala() {
        int numSala = service.indexSala();
        int[] selecciones = levantarFrameCrearSala(numSala);
        return service.crearSala(selecciones);
    }

    public String exito(int asientos) {
        int numSala = service.indexSala();
        int seleccion = crearSala.exito(numSala);
        return service.exito(seleccion, asientos);
    }

    private int[] levantarFrameCrearSala(int numSala) {
        FrameCrearSala frame = new FrameCrearSala(numSalas);
        frame.setVisible(true);
        
        /* Este ciclo revisa cada 250ms si el usuario ya clickeó un botón.
        En caso de que no espera otros 250ms, pero si sí entonces retorna la selección */
        while (true) {
            int seleccion = frame.getSeleccion();
            int asientos = frame.getAsientos();
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
                    return new int[]{seleccion, asientos};
            }
        }
    }
    
}
