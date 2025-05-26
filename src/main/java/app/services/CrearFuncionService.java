/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.services;

import app.models.Sala;
import client.CineClient;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import session.Session;

/**
 *
 * @author Juan José Molano Franco
 */
public class CrearFuncionService {
    
    private String mensajeVerificacion;
    private String[] datos;
    private final CineClient cliente;
    
    public CrearFuncionService() {
        cliente = new CineClient();
    }

    public String ingresarDatos(Object[] selecciones) {
        int seleccion = (int) selecciones[0];
        this.datos = (String[]) selecciones[1];;
        switch (seleccion) {
            case 0:  // Se cierra el frame con la X
                return "salida";
            case 1:  // Cerrar
                return "GestionSala_gestionSala";
            case 2:  // Crear función
                String mensajeVerificacion = verificarDatos(datos);
                if (mensajeVerificacion == null) {
                    return "CrearFuncion_exito";
                } else {
                    this.mensajeVerificacion = mensajeVerificacion;
                    return "CrearFuncion_error";
                }
            default:  // Botón no configurado
                throw new Error("Botón no configurado");
        }
    }

    private String verificarDatos(String[] datos) {
        String titulo = datos[0];
        String inicio = datos[1];
        String fin = datos[2];
        if (!verificarTitulo(titulo)) {
            return "El titulo es inválido";
        }
        if (!verificarFecha(inicio)) {
            return "El formato de la fecha de inicio es inválido";
        }
        if (!verificarFecha(fin)) {
            return "El formato de la fecha de fin es inválido";
        }
        return null;
    }

    private boolean verificarTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            return false;
        }
        return true;
    }

    private boolean verificarFecha(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d:HH[:mm]");
        try {
            LocalDateTime.parse(fecha, formatter);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void crearFuncion(Sala sala) throws Exception {
        cliente.createFuncion(sala, datos, Session.getToken());
    }

    public String exito(int selection) {
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

    public String error(int selection) {
        if (selection == 0) {  // Presiona OK
            return "CrearFuncion_ingresarDatos";
        } else if (selection == 2) {  // Presiona CANCEL
            return "GestionSala_gestionSala";
        } else if (selection == -1) {  // Cierra la ventana
            return "salida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }

    public String getMensajeVerificacion() {
        return mensajeVerificacion;
    }

}
