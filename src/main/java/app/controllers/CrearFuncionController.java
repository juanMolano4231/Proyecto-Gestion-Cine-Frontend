/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.controllers;

import app.frames.FrameCrearFuncion;
import app.models.Sala;
import app.services.CrearFuncionService;
import app.views.ViewCrearFuncion;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan José Molano Franco
 */
public class CrearFuncionController {
    
    private final CrearFuncionService service;
    private final ViewCrearFuncion view;
    
    public CrearFuncionController() {
        service = new CrearFuncionService();
        view = new ViewCrearFuncion();
    }

    public String ingresarDatos() {
        Object[] selecciones = levantarFrameCrearFuncion();
        return service.ingresarDatos(selecciones);
    }
    
    public String error() {
        String message = service.getMensajeVerificacion();
        int seleccion = view.error(message);
        return service.error(seleccion);
    }

    private Object[] levantarFrameCrearFuncion() {
        FrameCrearFuncion frame = new FrameCrearFuncion();
        frame.setVisible(true);

        /* Este ciclo revisa cada 250ms si el usuario ya clickeó un botón.
        En caso de que no espera otros 250ms, pero si sí entonces retorna la selección */
        while (true) {
            int seleccion = frame.getSeleccion();
            String[] datos = frame.getDatos();
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
                    return new Object[]{seleccion, datos};
            }
        }
    }

    public String exito(Sala sala) {
        try {
            service.crearFuncion(sala);
        } catch (Exception ex) {
            ex.printStackTrace();
            notificar(ex.getMessage());
            return "GestionSala_gestionSala";
        }
        int seleccion = view.exito();
        return service.exito(seleccion);
    }
    
    private void notificar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

}
