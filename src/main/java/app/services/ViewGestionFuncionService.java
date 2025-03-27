/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.services;

import app.frames.FrameGestionFuncion;
import app.views.ViewGestionFuncion;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Juan José Molano Franco
 */
public class ViewGestionFuncionService {

    private final ViewGestionFuncion gestionFuncion;

    public ViewGestionFuncionService() {
        this.gestionFuncion = new ViewGestionFuncion();
    }
    
    public String gestionFuncion() {
        FrameGestionFuncion frame = new FrameGestionFuncion();
        frame.setVisible(true);

        /* Este ciclo revisa cada 250ms si el usuario ya clickeó un botón.
        En caso de que no espera otros 250ms, pero si sí entonces toma la ruta */
        while (true) {
            int seleccion = frame.getSeleccion();
            switch (seleccion) {
                case 0:  // Se cierra el frame con la X
                    frame.dispose();
                    return "salida";
                case 1:  // Volver
                    frame.dispose();
                    return "GestionSala_gestionSala";
                case 2:  // Borrar función
                    frame.dispose();
                    if (hayAsientosOcupados()) {
                        return "GestionFuncion_falloAlBorrar";
                    } else {
                        return "GestionFuncion_exitoAlBorrar";
                    }
                default:  // Valor default, preferiblemente un número negativo
                    // Detiene el ciclo por 250 ms
                    try {
                        TimeUnit.MILLISECONDS.sleep(250);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                    break;
            }
        }
    }
    
    public String falloAlBorrar() {
        int selection = gestionFuncion.falloAlBorrar();
        if (selection == 0) {  // Presiona OK
            return "GestionFuncion_gestionFuncion";
        } else if (selection == 2) {  // Presiona CANCEL
            return "GestionFuncion_gestionFuncion";
        } else if (selection == -1) {  // Cierra la ventana
            return "salida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }
    
    public String exitoAlBorrar() {
        int selection = gestionFuncion.exitoAlBorrar();
        if (selection == 0) {  // Presiona OK
            return "GestionSala_gestionSala";
        } else if (selection == 2) {  // Presiona CANCEL
            return "GestionSala_gestionSala";
        } else if (selection == -1) {  // Cierra la ventana
            return "salida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }
    
    
    /* Checkea si la función ya tiene por lo menos un asiento ocupado */
    private boolean hayAsientosOcupados() {
        return false;
    }
}
