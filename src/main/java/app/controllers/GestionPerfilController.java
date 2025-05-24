package app.controllers;

import app.models.Sala;
import app.models.Usuario;
import app.services.GestionPerfilService;
import app.frames.*;
import app.models.Cliente;
import app.models.Funcion;
import client.CineClient;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GestionPerfilController {

    private Usuario usuario;
    Funcion funcion;
    private final GestionPerfilService service;

    public GestionPerfilController() {
        service = new GestionPerfilService();
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        service.setUsuario(usuario);
    }

    public String verPerfil(Usuario usuario) {
        Object[] seleccion = levantarFramePerfil(usuario);
        return service.verPerfil(seleccion);
    }

    public Object[] verTickets(Usuario usuario) {
        Object[] seleccion = levantarFrameTickets(usuario);
        String ruta = service.verTickets(seleccion);
        Funcion funcion = (Funcion) seleccion[1];
        int asiento = (int) seleccion[2];
        return new Object[]{ruta, funcion, asiento};
    }

    public Object[] verFunciones(Usuario usuario) {
        List<Sala> salas = service.getSalas();
        if (salas == null) {
            return new Object[]{"GestionPerfil_perfil", null};
        }
        Object[] seleccion = levantarFrameFunciones(usuario, salas);
        String ruta = service.verFunciones(seleccion);
        Funcion funcion = (Funcion) seleccion[1];
        return new Object[]{ruta, funcion};
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
        Cliente cliente = service.getClienteByUser(usuario.getUsuario());
        FrameVerTicketsUsuario frame = new FrameVerTicketsUsuario(cliente);
        frame.setVisible(true);
        while (true) {
            int seleccion = frame.getSeleccion();
            if (seleccion >= 0) {
                frame.dispose();
                Funcion funcion = service.buscarFuncionPorId(frame.getId());
                int asiento = frame.getAsiento();
                return new Object[]{seleccion, funcion, asiento};
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
                Funcion funcion = service.buscarFuncionPorId(frame.getFuncionId());
                return new Object[]{seleccion, funcion};
            }
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public String comprarTicket(Usuario usuario, Funcion funcion) {
        return service.comprarTicket(usuario, funcion);
    }

    public String devolverTicket(Usuario usuario, Funcion funcion, int asiento) {
        return service.devolverTicket(usuario, funcion, asiento);
    }

}
