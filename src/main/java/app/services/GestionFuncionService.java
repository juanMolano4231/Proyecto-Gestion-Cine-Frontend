/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.services;

import app.frames.FrameGestionFuncion;
import app.models.Funcion;
import app.models.Sala;
import app.views.ViewGestionFuncion;
import client.CineClient;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Juan José Molano Franco
 */
public class GestionFuncionService {

    private final ViewGestionFuncion gestionFuncion;
    private final CineClient cliente;

    public GestionFuncionService() {
        this.gestionFuncion = new ViewGestionFuncion();
        cliente = new CineClient();
    }
    
    public String gestionFuncion(int seleccion, Funcion funcion) {
        switch (seleccion) {
            case 0:  // Se cierra el frame con la X
                return "salida";
            case 1:  // Volver
                return "GestionSala_gestionSala";
            case 2:  // Borrar función
                if (hayAsientosOcupados(funcion)) {
                    return "GestionFuncion_falloAlBorrar";
                } else {
                    return "GestionFuncion_exitoAlBorrar";
                }
            default:  // Botón no configurado
                throw new Error("Botón no configurado");
        }
    }
    
    public String falloAlBorrar(int selection) {
        if (selection == 0) {  // Presiona OK
            return "GestionFuncion_gestionFuncion";
        } else if (selection == 2) {  // Presiona CANCEL
            return "GestionFuncion_gestionFuncion";
        } else if (selection == -1) {  // Cierra la ventana
            return "salida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }
    
    public String exitoAlBorrar() {
        int selection = gestionFuncion.exitoAlBorrar();
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
    
    
    /* Checkea si la función ya tiene por lo menos un asiento ocupado */
    private boolean hayAsientosOcupados(Funcion funcion) {
        boolean[] asientos = funcion.getAsientos();
        for (int i = 0; i < asientos.length; i++) {
            if (asientos[i]) {
                return true;
            }
        }
        return false;
    }

    public void borrarFuncion(Sala sala, Funcion funcion) throws Exception {
//        System.out.println("++++++++");
//        for (Funcion f : sala.getFunciones()) {
//            System.out.println(f.getTitulo() + " " + f.getId());
//        }
        System.out.println("size: " + sala.getFunciones().size());
        System.out.println("pasada: " + funcion.getId() + " " + funcion.getTitulo());
//        boolean contenia = sala.getFunciones().remove(funcion);
//        System.out.println("contenia: " + contenia);
        for (int i = 0; i < sala.getFunciones().size(); i++) {
            Funcion f = sala.getFunciones().get(i);
            System.out.println("funcion: " + f.getId() + " " + f.getTitulo());
            if (f.getId() == funcion.getId()) {
                sala.getFunciones().remove(i);
            }
        }
        cliente.updateSala(sala);
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
    
    public List<Sala> getSalas() {
        List<Sala> salas = cliente.getSalas();
        return salas;
    }
}
