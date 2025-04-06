/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.services;

import app.models.Sala;
import app.models.Usuario;
import client.CineClient;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Johan
 */
public class GestionPerfilService {

    private Usuario usuario;
    private final CineClient cliente;

    public GestionPerfilService() {
        this.cliente = new CineClient();
    }

    public String verPerfil(Object[] seleccion) {
        int opcion = (int) seleccion[0];
        switch (opcion) {
            case 0:
                return "salida";
            case 1:
                return "Bienvenida_bienvenida";
            case 2:
                return "GestionPerfil_verFunciones";
            case 3:
                return "GestionPerfil_verTickets";
            default:
                throw new Error("Botón no configurado");
        }
    }

    public String verTickets(Object[] seleccion) {
        int opcion = (int) seleccion[0];
        switch (opcion) {
            case 0:
                return "salida";
            case 1:
                return "GestionPerfil_perfil";
            case 2:
                return "GestionPerfil_devolver";
            default:
                throw new Error("Botón no configurado");
        }
    }

    public String verFunciones(Object[] seleccion) {
        int opcion = (int) seleccion[0];
        switch (opcion) {
            case 0:
                return "salida";
            case 1:
                return "GestionPerfil_perfil";
            case 2:
                return "GestionPerfil_comprarTicket";
            default:
                throw new Error("Botón no configurado");
        }
    }

    public String comprarTicket(Usuario usuario) {
        try {
            cliente.postUsuario(usuario.getUsuario(), usuario);
            notificar("Compra realizada con exito");
            return "GestionPerfil_verFunciones";
        } catch (Exception e) {
            notificar("Error al realizar la compra:\n" + e.getMessage());
            return "GestionPerfil_verFunciones";
        }
    }

    private void notificar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public List<Sala> getSalas() {
        return cliente.getSalas();
    }
}
