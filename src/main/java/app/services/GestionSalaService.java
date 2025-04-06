/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.services;

import app.models.Funcion;
import app.models.Sala;
import client.CineClient;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan José Molano Franco
 */
public class GestionSalaService {
    
    private final CineClient cliente;
    
    public GestionSalaService() {
        cliente = new CineClient();
    }

    public Object[] gestionSala(Object[] selecciones, Sala sala) {
        int seleccion = (int) selecciones[0];
        Funcion funcionSeleccionada = (Funcion) selecciones[1];
        switch (seleccion) {
            case 0:  // Se cierra el frame con la X
                return new Object[]{"salida", null};
            case 1:  // Volver
                return new Object[]{"GestionCine_verSalas", null};
            case 2:  // Borrar sala
                if (hayTiquetesPendientes(sala)) {
                    return new Object[]{"GestionSala_falloAlBorrar", null};
                } else {
                    return new Object[]{"GestionSala_exitoAlBorrar", null};
                }
            case 3:  // Crear nueva función
                return new Object[]{"CrearFuncion_ingresarDatos", null};
            case 4:  // Gestionar función n
                return new Object[]{"GestionFuncion_gestionFuncion", funcionSeleccionada};
            default:  // Botón no configurado
                throw new Error("Botón no configurado");
        }
    }
    
    public String falloAlBorrar(int selection) {
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
    
    public String exitoAlBorrar(int selection) {
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
    private boolean hayTiquetesPendientes(Sala sala) {
        List<Funcion> funciones = sala.getFunciones();
        for (Funcion f : funciones) {
            boolean[] asientos = f.getAsientos();
            if (contieneTrue(asientos)) {
                return true;
            }
        }
        return false;
    }
    
    private void notificar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public String borrarSala(Sala sala) {
        try {
            cliente.deleteSala(sala);
        } catch (Exception ex) {
            notificar(ex.getMessage());
            return "GestionCine_verSalas";
        }
        return null;
    }

    private boolean contieneTrue(boolean[] asientos) {
        for (boolean b : asientos) {
            if (b == true) {
                return true;
            }
        }
        return false;
    }

    public List<Sala> getSalas() {
        List<Sala> salas = cliente.getSalas();
        return salas;
    }

    public Sala reloadSala(Sala sala) {
        List<Sala> salas = getSalas();
        for (Sala s: salas) {
            if (s.getId() == sala.getId()) {
                return s;
            }
        }
        return null;
    }
}
