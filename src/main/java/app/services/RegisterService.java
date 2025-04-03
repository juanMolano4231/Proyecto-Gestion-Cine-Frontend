/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.services;

import app.models.Usuario;
import app.views.ViewRegister;
import client.CineClient;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan José Molano Franco
 */
public class RegisterService {
    
    private final CineClient cliente;
    
    public RegisterService() {
        cliente = new CineClient();
    }
    
    public Object[] pideNombreUsuario(String nombreUsuario) {
        try {
            if (nombreUsuario == null) {
                return new Object[]{"Bienvenida_bienvenida", null};
            }
            if (!nombreUsuarioValido(nombreUsuario)) {
                return new Object[]{"Register_usuarioInvalido", null};
            } else if (nombreUsuarioOcupado(nombreUsuario)) {
                return new Object[]{"Register_usuarioOcupado", null};
            } else {
                return new Object[]{"Register_pidePin", nombreUsuario};
            }
        } catch (Exception ex) {
            notificar(ex.getMessage());
            ex.printStackTrace();
            return new Object[]{"Bienvenida_bienvenida", null};
        }
    }
    
    public String usuarioInvalido(int selection) {
        if (selection == 0) {  // Presiona OK
            return "Register_pideNombreUsuario";
        } else if (selection == 2) {  // Presiona CANCEL
            return "Bienvenida_bienvenida";
        } else if (selection == -1) {  // Cierra la ventana
            return "salida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }
    
    public String usuarioOcupado(int selection) {
        if (selection == 0) {  // Presiona OK
            return "Register_pideNombreUsuario";
        } else if (selection == 2) {  // Presiona CANCEL
            return "Bienvenida_bienvenida";
        } else if (selection == -1) {  // Cierra la ventana
            return "salida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }
    
    public Object[] pidePin(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return new Object[]{"Register_pinInvalido", null};
        }
        return new Object[]{"Register_exito", input};
    }
    
    public String pinInvalido(int selection) {
        if (selection == 0) {  // Presiona OK
            return "Register_pidePin";
        } else if (selection == 2) {  // Presiona CANCEL
            return "Bienvenida_bienvenida";
        } else if (selection == -1) {  // Cierra la ventana
            return "salida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }
    
    public String exito(int selection, String usu, String pin) {
        try {
            registrarUsuario(usu, pin);
        } catch (Exception ex) {
            notificar(ex.getMessage());
            ex.printStackTrace();
            return "Bienvenida_bienvenida";
        }

        if (selection == 0 || selection == 2) {  // Presiona OK o CANCEL
            return "Bienvenida_bienvenida";
        } else if (selection == -1) {  // Cierra la ventana
            return "salida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }
    
    // Validaciones
    private static boolean nombreUsuarioValido(String usu) {
        if (usu == null || usu.isBlank()) {
            return false;
        }
        for (int i = 0; i < usu.length(); i++) {
            if (Character.isWhitespace(usu.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean nombreUsuarioOcupado(String nombreUsuario) throws Exception {
        List<Usuario> usuarios = cliente.getAllUsuarios();
        if (usuarios == null) {
            throw new Exception("Hubo un error al conectar con el servidor");
        }
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }

    // Otros procesos
    private void notificar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void registrarUsuario(String usu, String pin) throws Exception {
        cliente.createUsuario(usu, pin);
    }
    
}
