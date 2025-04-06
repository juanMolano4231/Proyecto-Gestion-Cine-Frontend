/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controllers;

import app.models.Sala;
import app.models.Usuario;
import app.services.GestionPerfilService;
import app.frames.*;
import app.models.Funcion;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Johan
 */
public class GestionPerfilController {

    private final GestionPerfilService service;

    public GestionPerfilController() {
        service = new GestionPerfilService();
    }

    public String verPerfil(Usuario usuario) {
        Object[] seleccion = levantarFramePerfil(usuario);
        return service.verPerfil(seleccion);
    }

    public String verTickets(Usuario usuario) {
        Object[] seleccion = levantarFrameTickets(usuario);
        return service.verTickets(seleccion);
    }

    public String verFunciones(Usuario usuario) {
        List<Sala> salas = service.getSalas();
        Object[] seleccion = levantarFrameFunciones(usuario, salas);
        return service.verFunciones(seleccion);
    }

    private Object[] levantarFramePerfil(Usuario usuario) {
        FrameGestionPerfil frame = new FrameGestionPerfil(usuario);
        frame.setVisible(true);
        while (true) {
            int seleccion = frame.getSeleccion();
            if (seleccion >= 0) {
                frame.dispose();
                return new Object[]{seleccion};
            }
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private Object[] levantarFrameTickets(Usuario usuario) {
        FrameVerTicketsUsuario frame = new FrameVerTicketsUsuario(usuario);
        frame.setVisible(true);
        while (true) {
            int seleccion = frame.getSeleccion();
            if (seleccion >= 0) {
                frame.dispose();
                return new Object[]{seleccion};
            }
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private Object[] levantarFrameFunciones(Usuario usuario, List<Sala> salas) {
        FrameVerFuncionesUsuario frame = new FrameVerFuncionesUsuario(usuario, salas);
        frame.setVisible(true);
        while (true) {
            int seleccion = frame.getSeleccion();
            if (seleccion >= 0) {
                frame.dispose();
                return new Object[]{seleccion};
            }
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public String comprarTicket(Usuario usuario, Funcion funcion) {
        return service.comprarTicket(usuario);
    }

}
