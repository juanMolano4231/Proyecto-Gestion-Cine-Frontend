/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.services;

import java.util.concurrent.TimeUnit;
import app.frames.*;

/**
 *
 * @author johan
 */
public class ViewGestionPerfilService {

    public String verPerfil() {
        FrameGestionPerfil frame = new FrameGestionPerfil();
        frame.setVisible(true);

        while (true) {
            int seleccion = frame.getSeleccion();
            switch (seleccion) {
                case 0:  // Se cierra el frame con la X
                    frame.dispose();
                    return "salida";
                case 1:  // Cierra sesion y vuelve a bienvenida
                    frame.dispose();
                    return "Bienvenida_bienvenida";
                case 2:  // Muestra vista de funciones
                    frame.dispose();
                    return "GestionPerfil_funciones";
                case 3: // Muestra vista de tickets
                    frame.dispose();
                    return "GestionPerfil_tickets";
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

    public String verTickets() {
        FrameTickets frame = new FrameTickets();
        frame.setVisible(true);

        while (true) {
            int seleccion = frame.getSeleccion();
            switch (seleccion) {
                case 0:  // Se cierra el frame con la X
                    frame.dispose();
                    return "salida";
                case 1:  //Vuelve a la vista de usuario
                    frame.dispose();
                    return "GestionPerfil_perfil";
                case 2:  // Devuelve el ticket seleccionado
                    frame.dispose();
                    return "GestionPerfil_devolver";
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
