/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.services;

import app.frames.FrameVerSalas;
import app.models.Sala;
import client.CineClient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan José Molano Franco
 */
public class GestionCineService {

    private final CineClient cliente;

    public GestionCineService() {
        cliente = new CineClient();
    }

    public Object[] verSalas(Object[] selecciones) {
        int seleccion = (int) selecciones[0];
        Sala salaSeleccionada = (Sala) selecciones[1];
        switch (seleccion) {
            case 0:  // Se cierra el frame con la X
                return new Object[]{"salida", null};
            case 1:  // Cerrar sesión
                return new Object[]{"Bienvenida_bienvenida", null};
            case 2:  // Crear sala
                return new Object[]{"CrearSala_crearSala", null};
            case 3:  // Gestionar sala
                if (salaSeleccionada != null) {
                    return new Object[]{"GestionSala_gestionSala", salaSeleccionada};
                } else {
                    notificar("No hay o no se pueden cargar las salas en este momento");
                    return new Object[]{"GestionCine_verSalas", null};
                }
            default:  // Botón no configurado
                throw new Error("Botón no configurado");
        }
    }

    public List<Sala> getSalas() {
        List<Sala> salas = cliente.getSalas();
        return salas;
    }

    private void notificar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
