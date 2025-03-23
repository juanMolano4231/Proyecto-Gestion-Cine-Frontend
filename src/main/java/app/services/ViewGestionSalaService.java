/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.services;

import app.frames.FrameGestionSala;
import app.views.ViewGestionSala;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Juan José Molano Franco
 */
public class ViewGestionSalaService {
    
    private final ViewGestionSala gestionSala;
    
    public ViewGestionSalaService() {
        gestionSala = new ViewGestionSala();
    }

    public Object[] gestionSala() {
        FrameGestionSala frame = new FrameGestionSala();
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
                case 2:  // Borrar sala
                    frame.dispose();
                    if (hayTiquetesPendientes()) {
                        return new Object[]{"GestionSala_falloAlBorrar", -1};
                    } else {
                        return new Object[]{"GestionSala_exitoAlBorrar", -1};
                    }
                case 3:  // Crear nueva función
                    frame.dispose();
                    return new Object[]{"CrearFuncion_ingresarTitulo", -1};
                case 4:  // Gestionar función n
                    int funcionSeleccionada = frame.getFuncionSeleccionada();
                    if (funcionSeleccionada == -1) {
                        break;
                    }
                    frame.dispose();
                    return new Object[]{"GestionFuncion_gestionFuncion", funcionSeleccionada};
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
        int selection = gestionSala.falloAlBorrar();
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
    
    public String exitoAlBorrar() {
        int selection = gestionSala.exitoAlBorrar();
        if (selection == 0) {  // Presiona OK
            return "GestionCine_verSalas";
        } else if (selection == 2) {  // Presiona CANCEL
            return "GestionCine_verSalas";
        } else if (selection == -1) {  // Cierra la ventana
            return "salida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }
    
    /* Este método checkea si en esta sala hay por lo menos una función sin
    pasar que haya vendido por lo menos un tiquete. Si este es el caso, retorna
    true*/
    private boolean hayTiquetesPendientes() {
        return false;
    }
}
