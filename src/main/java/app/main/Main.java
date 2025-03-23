/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.main;

import com.formdev.flatlaf.FlatLightLaf;
import app.controllers.*;

/**
 *
 * @author Juan Jose Molano Franco
 */

public class Main {

    private static final ViewTestController testController = new ViewTestController();
    private static final ViewBienvenidaController bienvenidaController = new ViewBienvenidaController();
    private static final ViewLoginController loginController = new ViewLoginController();
    private static final ViewRegisterController registerController = new ViewRegisterController();
    private static final ViewGestionCineController gestionCineController = new ViewGestionCineController();
    private static final ViewCrearSalaController crearSalaController = new ViewCrearSalaController();
    private static final ViewGestionPerfilController viewGestionPerfilController = new ViewGestionPerfilController();

    public static void main(String[] args) {
        looksAndFeelSetup();
        iniciarRouting();
    }

    private static void looksAndFeelSetup() {
        /* Estilo default de FlatLightLaf */
        FlatLightLaf.setup();
    }

    private static void iniciarRouting() {

        /* Guarda la ruta a la que se irá en la siguiente iteración del ciclo
        en cierta View y cierto Diálogo (cada método es un diálogo */
        String ruta = "Bienvenida_bienvenida";  // Ruta default, ViewBienvenida método bienvenida
        // Auxiliares
        String nombreUsuarioLogin = null;
        String pinLogin = null;
        String nombreUsuarioRegistro = null;
        String pinRegistro = null;
        int salaSeleccionada = -1;
        int asientosNuevaSala = -1;
        /* Para cargar la data de los métodos y usarla, siempre se sobrescribe */
        Object[] data;
        while (true) {
            System.out.println(asientosNuevaSala);
            switch (ruta) {
                // Test
                case "Test_botones":
                    ruta = test_botones();
                    break;
                // Salida
                case "salida":
                    System.exit(0);
                // ViewBienvenida
                case "Bienvenida_bienvenida":
                    ruta = bienvenida_bienvenida();
                    break;
                // ViewLogin
                case "Login_pideNombreUsuario":
                    data = login_pideNombreUsuario();
                    ruta = (String) data[0]; // ruta
                    nombreUsuarioLogin = (String) data[1]; // nombre de usuario
                    break;
                case "Login_usuarioInvalido":
                    ruta = login_usuarioInvalido();
                    break;
                case "Login_usuarioNoEncontrado":
                    ruta = login_usuarioNoEncontrado();
                    break;
                case "Login_pidePin":
                    data = login_pidePin();
                    ruta = (String) data[0]; // ruta
                    pinLogin = String.valueOf(data[1]); // pin
                    break;
                case "Login_pinIncorrecto":
                    ruta = login_pinIncorrecto();
                    break;
                case "Login_pinInvalido":
                    ruta = login_pinInvalido();
                    break;
                case "Login_exito":
                    ruta = login_exito(nombreUsuarioLogin);
                    break;
                // ViewRegister
                case "Register_pideNombreUsuario":
                    data = register_pideNombreUsuario();
                    ruta = (String) data[0];
                    nombreUsuarioRegistro = (String) data[1]; // Guarda nombre de usuario para registro
                    break;
                case "Register_usuarioInvalido":
                    ruta = register_usuarioInvalido();
                    break;
                case "Register_usuarioOcupado":
                    ruta = register_usuarioOcupado();
                    break;
                case "Register_pidePin":
                    data = register_pidePin();
                    ruta = (String) data[0];
                    pinRegistro = (String) data[1]; // Guarda pin del usuario para registro
                    break;
                case "Register_pinInvalido":
                    ruta = register_pinInvalido();
                    break;
                case "Register_exito":
                    ruta = register_exito();
                    break;
                // ViewGestionCine
                case "GestionCine_verSalas":
                    data = gestionCine_verSalas();
                    ruta = (String) data[0];
                    salaSeleccionada = (int) data[1];  // Guarda sala seleccionada para gestionar
                    break;
                // ViewCrearSala
                case "CrearSala_crearSala":
                    data = crearSala_crearSala();
                    ruta = (String) data[0];
                    asientosNuevaSala = (int) data[1];
                    break;
                case "CrearSala_exito":
                    ruta = crearSala_exito();
                    break;
                // ViewGestionPerfil
                case "GestionPerfil_perfil":
                    ruta = gestionPerfil_perfil();
                    break;
                // Default
                default:
                    throw new Error("No hay una ruta implementada para la ruta \""
                            + ruta + "\"");
            }
        }
    }

    // Testing
    public static String test_botones() {
        return testController.botones();
    }

    // ViewBienvenida
    private static String bienvenida_bienvenida() {
        return bienvenidaController.bienvenida();
    }

    // ViewLogin
    private static Object[] login_pideNombreUsuario() {
        return loginController.pideNombreUsuario();
    }

    private static String login_usuarioInvalido() {
        return loginController.usuarioInvalido();
    }

    private static String login_usuarioNoEncontrado() {
        return loginController.usuarioNoEncontrado();
    }

    private static Object[] login_pidePin() {
        return loginController.pidePin();
    }

    private static String login_pinIncorrecto() {
        return loginController.pinIncorrecto();
    }

    private static String login_pinInvalido() {
        return loginController.pinInvalido();
    }

    private static String login_exito(String nombreUsuario) {
        return loginController.exito(nombreUsuario);
    }

    // ViewRegister
    private static Object[] register_pideNombreUsuario() {
        return registerController.pideNombreUsuario();
    }

    private static String register_usuarioInvalido() {
        return registerController.usuarioInvalido();
    }

    private static String register_usuarioOcupado() {
        return registerController.usuarioOcupado();
    }

    private static Object[] register_pidePin() {
        return registerController.pidePin();
    }

    private static String register_pinInvalido() {
        return registerController.pinInvalido();
    }

    private static String register_exito() {
        return registerController.exito();
    }

    // ViewGestionCine
    private static Object[] gestionCine_verSalas() {
        return gestionCineController.verSalas();
    }

    // ViewCrearSala
    private static Object[] crearSala_crearSala() {
        return crearSalaController.crearSala();
    }

    private static String crearSala_exito() {
        return crearSalaController.exito();
    }

    // ViewGestionPerfil
    private static String gestionPerfil_perfil() {
        return viewGestionPerfilController.verPerfil();
    }

}
