/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.services;

import app.frames.FrameTestBotones;
import app.models.Funcion;
import app.models.Sala;
import client.CineClient;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Juan José Molano Franco
 */
public class TestService {
    
    private final CineClient cliente;
    
    public TestService() {
        cliente = new CineClient();
    }
    
    public String botones() {
        FrameTestBotones frame = new FrameTestBotones();
        frame.setVisible(true);

        /* Este ciclo revisa cada 250ms si el usuario ya clickeó un botón.
        En caso de que no espera otros 250ms, pero si sí entonces toma la ruta */
        while (true) {
            int seleccion = frame.getSeleccion();
            switch (seleccion) {
                case 0:  // Se cierra el frame con la X
                    frame.dispose();
                    return "RUTA INDEFINIDA";
                case 1:  // Botón 1
                    frame.dispose();
                    return "RUTA INDEFINIDA";
                case 2:  // Botón 2
                    frame.dispose();
                    return "RUTA INDEFINIDA";
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
