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
import session.Session;

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
                return "GestionPerfil_devolverTicket";
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
        if (funcion == null) {
            notificar("No hay ninguna funcion seleccionada");
            return "GestionPerfil_verFunciones";
        }
        try {
            Cliente clienteAEditar = getClienteByUser(usuario.getUsuario());

            if (cantidadAsientosDisponibles(funcion) <= 0) {
                notificar("Error al realizar la compra, no hay asientos libres");
                return "GestionPerfil_verFunciones";
            }

            int asientoDeseado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el asiento que desea comprar para la funcion: " + funcion.getId() + ", " + funcion.getTitulo()
                    + ", quedan: " + cantidadAsientosDisponibles(funcion) + " asientos."));
            clienteAEditar.getTiquetes().add(new Tiquete(funcion, asientoDeseado));

            if (asientoDeseado > funcion.getAsientos().length) {
                notificar("El asiento no existe");
                return "GestionPerfil_verFunciones";
            }

            if (funcion.getAsientos()[asientoDeseado - 1] == true) {
                notificar("Error al realizar la compra, el asiento no esta disponible");
                return "GestionPerfil_verFunciones";
            } else {
                funcion.getAsientos()[asientoDeseado - 1] = true;
                cliente.postCliente(usuario.getUsuario(), clienteAEditar, Session.getToken());
                cliente.updateFuncion(funcion);
                notificar("Tiquete comprado con exito");
                
                return "GestionPerfil_verFunciones";
            }
        } catch (Exception e) {
            e.printStackTrace();
            notificar("Error");
            return "GestionPerfil_verFunciones";
        }
    }

    public String devolverTicket(Usuario usuario, Funcion funcion, int asiento) {
        try {
            if (funcion == null) {
                notificar("No hay ningun tiquete seleccionado");
                return "GestionPerfil_verTickets";
            }

            Cliente clienteAEditar = getClienteByUser(usuario.getUsuario());

            if (clienteAEditar == null) {
                notificar("Cliente no encontrado");
                return "GestionPerfil_verFunciones";
            }

            Tiquete tiqueteAEliminar = null;
            for (Tiquete t : clienteAEditar.getTiquetes()) {
                if (t.getFuncion().getId() == funcion.getId() && t.getAsiento() == asiento) {
                    tiqueteAEliminar = t;
                    break;
                }
            }

            if (tiqueteAEliminar == null) {
                notificar("No se encontró un tiquete para ese asiento en esta función");
                return "GestionPerfil_verTickets";
            }

            funcion.getAsientos()[asiento - 1] = false;
            cliente.updateFuncion(funcion);

            clienteAEditar.getTiquetes().remove(tiqueteAEliminar);
            cliente.postCliente(usuario.getUsuario(), clienteAEditar, Session.getToken());
            cliente.borrarTiquete(funcion.getId(), asiento);

            notificar("Tiquete devuelto con éxito");
            return "GestionPerfil_verTickets";

        } catch (Exception e) {
            e.printStackTrace();
            notificar("Error");
            return "GestionPerfil_verFunciones";
        }
    }


    private void notificar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public List<Sala> getSalas() {
        return cliente.getSalas(Session.getToken());
    }

    public Funcion buscarFuncionPorId(int id) {
        List<Sala> salas = getSalas();
        if (salas == null) {
            return null;
        }
        for (Sala s : salas) {
            for (Funcion f : s.getFunciones()) {
                if (f.getId() == id) {
                    return f;
                }
            }
        }
        return null;
    }

    public int cantidadAsientosDisponibles(Funcion funcion) {
        boolean[] asientos = funcion.getAsientos();
        int disponibles = 0;
        for (boolean disponible : asientos) {
            if (!disponible) {
                disponibles++;
            }
        }
        return disponibles;
    }

    public Cliente getClienteByUser(String username) {
        return cliente.getClienteByUsername(username, Session.getToken());
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
