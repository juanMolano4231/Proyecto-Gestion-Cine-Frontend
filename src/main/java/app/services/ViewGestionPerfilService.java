/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.services;

import java.util.concurrent.TimeUnit;
import app.frames.FrameGestionPerfil;

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
                    return "RUTA INDEFINIDA";
                case 1:  // Botón 1
                    frame.dispose();
                    return "Bienvenida_bienvenida";
                case 2:  // Botón 2
                    frame.dispose();
                    return "ViewFunciones_funciones";
                case 3:
                    frame.dispose();
                    return "ViewTickets_tickets";
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
