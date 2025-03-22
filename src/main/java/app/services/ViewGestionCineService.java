/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.services;

import app.frames.FrameVerSalas;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Juan José Molano Franco
 */
public class ViewGestionCineService {
    
    public Object[] verSalas() {
        FrameVerSalas frame = new FrameVerSalas();
        frame.setVisible(true);

        /* Este ciclo revisa cada 250ms si el usuario ya clickeó un botón.
        En caso de que no espera otros 250ms, pero si sí entonces toma la ruta */
        while (true) {
            int seleccion = frame.getSeleccion();
            switch (seleccion) {
                case 0:  // Se cierra el frame con la X
                    frame.dispose();
                    return new Object[]{"salida", -1};
                case 1:  // Cerrar sesión
                    frame.dispose();
                    return new Object[]{"Bienvenida_bienvenida", -1};
                case 2:  // Crear sala
                    frame.dispose();
                    return new Object[]{"CrearSala_crearSala", -1};
                case 3:  // Gestionar sala
                    int salaSeleccionada = frame.getSalaSeleccionada();
                    if (salaSeleccionada == -1) {  // No se ha seleccionado una sala
                        break;
                    }
                    frame.dispose();
                    return new Object[]{"GestionSala_gestionSala", salaSeleccionada};
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
}
