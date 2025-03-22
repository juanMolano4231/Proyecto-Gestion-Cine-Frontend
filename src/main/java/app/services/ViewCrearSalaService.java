/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.services;

import app.frames.FrameCrearSala;
import app.views.ViewCrearSala;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Juan José Molano Franco
 */
public class ViewCrearSalaService {
    
    private final ViewCrearSala crearSala;
    
    public ViewCrearSalaService() {
        crearSala = new ViewCrearSala();
    }

    public Object[] crearSala() {
        FrameCrearSala frame = new FrameCrearSala();
        frame.setVisible(true);

        /* Este ciclo revisa cada 250ms si el usuario ya clickeó un botón.
        En caso de que no espera otros 250ms, pero si sí entonces toma la ruta */
        while (true) {
            int seleccion = frame.getSeleccion();
            switch (seleccion) {
                case 0:  // Se cierra el frame con la X
                    frame.dispose();
                    return new Object[]{"salida", -1};
                case 1:  // Volver
                    frame.dispose();
                    return new Object[]{"GestionCine_verSalas", -1};
                case 2:  // Crear
                    int asientos = frame.getAsientos();
                    if (asientos == -1) {
                        break;
                    }
                    frame.dispose();
                    return new Object[]{"CrearSala_exito", asientos};
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
    
    public String exito() {
        int selection = crearSala.exito();
        if (selection == 0 || selection == 2) {  // Presiona OK o CANCEL
            return "GestionCine_verSalas";
        } else if (selection == -1) {  // Cierra la ventana
            return "salida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }
    
}
