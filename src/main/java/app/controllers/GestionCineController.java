/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.controllers;

import app.frames.FrameVerSalas;
import app.models.Sala;
import app.services.GestionCineService;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Juan José Molano Franco
 */
public class GestionCineController {

    private final GestionCineService gestionCineService;
    
    public GestionCineController() {
        gestionCineService = new GestionCineService();
    }
    
    public Object[] verSalas() {
        List<Sala> salas = gestionCineService.getSalas();
        Object[] selecciones = levantarFrameSalas(salas);
        return gestionCineService.verSalas(selecciones);
    }
    
    public List<Sala> getSalas() {
        return gestionCineService.getSalas();
    }

    private Object[] levantarFrameSalas(List<Sala> salas) {
        FrameVerSalas frame = new FrameVerSalas(salas);
        frame.setVisible(true);

        /* Este ciclo revisa cada 250ms si el usuario ya clickeó un botón.
        En caso de que no espera otros 250ms, pero si sí entonces retorna la selección */
        while (true) {
            int seleccion = frame.getSeleccion();
            int indexSalaSeleccionada = frame.getIndexSalaSeleccionada();
            Sala salaSeleccionada = frame.getSalaSeleccionada();
            switch (seleccion) {
                case -1:  // Valor default, preferiblemente un número negativo
                    // Detiene el ciclo por 250 ms
                    try {
                        TimeUnit.MILLISECONDS.sleep(250);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                case 3:
                    if (indexSalaSeleccionada == -1) {  // No se ha seleccionado una sala
                        break;
                    }
                default:
                    frame.dispose();
                    return new Object[]{seleccion, indexSalaSeleccionada, salaSeleccionada};
            }
        }
    }
}
