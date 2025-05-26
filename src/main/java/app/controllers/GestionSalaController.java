/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.controllers;

import app.frames.FrameGestionSala;
import app.models.Funcion;
import app.models.Sala;
import app.services.GestionSalaService;
import app.views.ViewGestionSala;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Juan José Molano Franco
 */
public class GestionSalaController {

    private final GestionSalaService service;
    private final ViewGestionSala view;
    
    public GestionSalaController() {
        service = new GestionSalaService();
        view = new ViewGestionSala();
    }
    
    public Object[] gestionSala(Sala sala) {
        Sala salaActualizada = service.reloadSala(sala);
        if (salaActualizada == null) {
            return new Object[]{"GestionCine_verSalas", null};
        }
        Object[] selecciones = levantarFrameGestionSala(salaActualizada);
        return service.gestionSala(selecciones, salaActualizada);
    }
    
    public String falloAlBorrar() {
        int seleccion = view.falloAlBorrar();
        return service.falloAlBorrar(seleccion);
    }
    
    public String exitoAlBorrar(Sala sala) {
        String rutaAlterna = service.borrarSala(sala);  // En caso de que haya un error de conexión
        if (rutaAlterna != null) {
            return rutaAlterna;
        }
        int seleccion = view.exitoAlBorrar();
        return service.exitoAlBorrar(seleccion);
    }

    private Object[] levantarFrameGestionSala(Sala sala) {
        FrameGestionSala frame = new FrameGestionSala(sala);
        frame.setVisible(true);

        /* Este ciclo revisa cada 250ms si el usuario ya clickeó un botón.
        En caso de que no espera otros 250ms, pero si sí entonces retorna la selección */
        while (true) {
            int seleccion = frame.getSeleccion();
            Funcion funcionSeleccionada = frame.getFuncionSeleccionada();
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
                    return new Object[]{seleccion, funcionSeleccionada};
            }
        }
    }
    
}
