/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.services;

import app.models.Cliente;
import app.models.Funcion;
import app.models.Sala;
import app.models.Tiquete;
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

    public String comprarTicket(Usuario usuario, Funcion funcion) {
        try {
            List<Usuario> usuarios = cliente.getAllUsuarios();
            Cliente clienteAEditar = null;

            for (Usuario usuarioEncontrado : usuarios) {
                if (usuarioEncontrado.getUsuario().equals(usuario.getUsuario())) {
                    if (usuarioEncontrado instanceof Cliente) {
                        clienteAEditar = (Cliente) usuarioEncontrado;
                    }
                    break;
                }
            }
            int asientoDeseado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el asiento que desea comprar"));
            clienteAEditar.getTiquetes().add(new Tiquete(funcion, asientoDeseado));

            if (funcion.getAsientos()[asientoDeseado] == false) {
                notificar("Error al realizar la compra, el asiento no esta disponible");
                return "GestionPerfil_verFunciones";
            } else {
                notificar("Tiquete comprado con exito");
                funcion.getAsientos()[asientoDeseado] = false;
                cliente.postUsuario(usuario.getUsuario(), usuario);
                return "GestionPerfil_verFunciones";
            }
        } catch (Exception e) {
            notificar("Error");
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
