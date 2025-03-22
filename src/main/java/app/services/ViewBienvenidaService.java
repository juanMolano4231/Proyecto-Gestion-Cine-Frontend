/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.services;

import app.frames.FrameBienvenida;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Juan José Molano Franco
 */
public class ViewBienvenidaService {

    public String bienvenida() {
        FrameBienvenida frame = new FrameBienvenida();
        frame.setVisible(true);

        /* Este ciclo revisa cada 250ms si el usuario ya clickeó un botón.
        En caso de que no espera otros 250ms, pero si sí entonces toma la ruta */
        while (true) {
            int seleccion = frame.getSeleccion();
            switch (seleccion) {
                case 0:  // Se cierra el frame con la X
                case 1:  // Cerrar
                    frame.dispose();
                    return "salida";
                case 2:  // Iniciar sesión
                    frame.dispose();
                    return "Login_pideNombreUsuario";
                case 3:  // Iniciar sesión
                    frame.dispose();
                    return "Register_pideNombreUsuario";
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
