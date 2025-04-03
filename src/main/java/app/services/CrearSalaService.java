/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.services;

import app.frames.FrameCrearSala;
import app.models.Sala;
import app.views.ViewCrearSala;
import client.CineClient;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan José Molano Franco
 */
public class CrearSalaService {
    
    private final CineClient cliente;
    
    public CrearSalaService() {
        cliente = new CineClient();
    }

    public Object[] crearSala(int[] selecciones) {
        int seleccion = selecciones[0];
        int asientos = selecciones[1];
        switch (seleccion) {
            case 0:  // Se cierra el frame con la X
                return new Object[]{"salida", -1};
            case 1:  // Volver
                return new Object[]{"GestionCine_verSalas", -1};
            case 2:  // Crear
                return new Object[]{"CrearSala_exito", asientos};
            default:  // Botón no configurado
                throw new Error("Botón no configurado");
        }
    }
    
    public String exito(int selection, int asientos) {
        try {
            createSala(asientos);
        } catch (Exception ex) {
            notificar(ex.getMessage());
            ex.printStackTrace();
        }
        
        if (selection == 0 || selection == 2) {  // Presiona OK o CANCEL
            return "GestionCine_verSalas";
        } else if (selection == -1) {  // Cierra la ventana
            return "salida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }

    //Otros procesos
    private void createSala(int asientos) throws Exception {
        cliente.createSala(asientos);
    }
    
    private void notificar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    /* Retorna el index de la sala que se está creando */
    public int indexSala() {
        List<Sala> salas = cliente.getSalas();
        return salas.size() + 1;
    }
    
}
