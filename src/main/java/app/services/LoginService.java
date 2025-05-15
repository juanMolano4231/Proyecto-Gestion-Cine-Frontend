/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.services;

import app.models.Usuario;
import app.views.ViewLogin;
import client.CineClient;

/**
 *
 * @author Juan José Molano Franco
 */
public class LoginService {

    private Usuario usuario;
    private final CineClient cliente;

    public LoginService() {
        cliente = new CineClient();
    }

    public Object[] pideNombreUsuario(String input) {
        if (input == null) {
            return new Object[]{"Bienvenida_bienvenida", null};
        }
        if (!nombreUsuarioValido(input)) {
            return new Object[]{"Login_usuarioInvalido", null};
        }

        this.usuario = cliente.buscarUsuario(input);
        if (usuario != null && usuario.getUsuario().equals(input)) {
            return new Object[]{"Login_pidePin", input};
        } else {
            return new Object[]{"Login_usuarioNoEncontrado", null};
        }
    }

    public String usuarioInvalido(int selection) {
        if (selection == 0) {
            return "Login_pideNombreUsuario";
        } else if (selection == 2) {
            return "Bienvenida_bienvenida";
        } else if (selection == -1) {
            return "salida";
        } else {
            throw new Error("Seleccion" + selection + "sin ruta");
        }
    }

    public String usuarioNoEncontrado(int selection) {
        if (selection == 0) {
            return "Login_pideNombreUsuario";
        } else if (selection == 2) {
            return "Bienvenida_bienvenida";
        } else if (selection == -1) {
            return "salida";
        } else {
            throw new Error("Seleccion" + selection + "sin ruta");
        }
    }

    public Object[] pidePin(String input) {
        if (input == null) {
            return new Object[]{"Bienvenida_bienvenida", null, null};
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return new Object[]{"Login_pinInvalido", null, null};
        }

        Usuario autenticado = cliente.login(usuario.getUsuario(), input);
        if (autenticado != null) {
            this.usuario = autenticado;
            return new Object[]{"Login_exito", input, usuario};
        } else {
            return new Object[]{"Login_pinIncorrecto", null, null};
        }
    }

    public String pinIncorrecto(int selection) {
        if (selection == 0) {  // Presiona OK
            return "Login_pidePin";
        } else if (selection == 2) {  // Presiona CANCEL
            return "Bienvenida_bienvenida";
        } else if (selection == -1) {  // Cierra la ventana
            return "salida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }

    public String pinInvalido(int selection) {
        if (selection == 0) {  // Presiona OK
            return "Login_pidePin";
        } else if (selection == 2) {  // Presiona CANCEL
            return "Bienvenida_bienvenida";
        } else if (selection == -1) {  // Cierra la ventana
            return "salida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }

    public String exito(int selection) {
        if (selection == 0) {  // Presiona OK
            String tipo = cliente.consultarTipo(usuario);
            if (tipo == null) {
                return "Bienvenida_bienvenida";
            }
            if (tipo.equals("admin")) {
                return "GestionCine_verSalas";
            } else {
                return "GestionPerfil_perfil";
            }
        } else if (selection == 2) {  // Presiona CANCEL
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
}
