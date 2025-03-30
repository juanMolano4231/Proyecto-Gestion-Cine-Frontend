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
    private static final RegisterController registerController = new RegisterController();
    private static final ViewGestionCineController gestionCineController = new ViewGestionCineController();
    private static final ViewCrearSalaController crearSalaController = new ViewCrearSalaController();
    private static final ViewGestionPerfilController viewGestionPerfilController = new ViewGestionPerfilController();
    private static final ViewGestionSalaController gestionSalaController = new ViewGestionSalaController();
    private static final ViewGestionFuncionController gestionFuncionController = new ViewGestionFuncionController();

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
        int salaSeleccionada = -1;  // Sala seleccionada para gestionarla
        int asientosNuevaSala = -1;
        int funcionSeleccionada = -1;  // Función seleccionada para gestionarla
        /* Para cargar la data de los métodos y usarla, siempre se sobrescribe */
        Object[] data;
        while (true) {
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
                // ViewGestionSala
                case "GestionSala_gestionSala":
                    data = gestionSala_gestionSala();
                    ruta = (String) data[0];
                    funcionSeleccionada = (int) data[1];
                    break;
                case "GestionSala_falloAlBorrar":
                    ruta = gestionSala_falloAlBorrar();
                    break;
                case "GestionSala_exitoAlBorrar":
                    ruta = gestionSala_exitoAlBorrar();
                    break;
                // ViewGestionPerfil
                case "GestionPerfil_perfil":
                    ruta = gestionPerfil_perfil();
                    break;
                case "GestionPerfil_verTickets":
                    ruta = gestionPerfil_verTickets();
                    break;
                case "GestionPerfil_verFunciones":
                    ruta = gestionPerfil_verFunciones();
                    break;
                // ViewGestionFuncion
                case "GestionFuncion_gestionFuncion":
                    ruta = gestionFuncion_gestionFuncion();
                    break;
                case "GestionFuncion_exitoAlBorrar":
                    ruta = gestionFuncion_exitoAlBorrar();
                    break;
                case "GestionFuncion_falloAlBorrar":
                    ruta = gestionFuncion_falloAlBorrar();
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
    
    // ViewGestionSala
    private static Object[] gestionSala_gestionSala() {
        return gestionSalaController.gestionSala();
    }
    
    private static String gestionSala_falloAlBorrar() {
        return gestionSalaController.falloAlBorrar();
    }
    
    private static String gestionSala_exitoAlBorrar() {
        return gestionSalaController.exitoAlBorrar();
    }

    // ViewGestionPerfil
    private static String gestionPerfil_perfil() {
        return viewGestionPerfilController.verPerfil();
    }
    
    private static String gestionPerfil_verTickets() {
        return viewGestionPerfilController.verTickets();
    }
    
    private static String gestionPerfil_verFunciones() {
        return viewGestionPerfilController.verFunciones();
    }

    // ViewGestionFuncion
    private static String gestionFuncion_gestionFuncion() {
        return gestionFuncionController.gestionFuncion();
    }
    
    private static String gestionFuncion_exitoAlBorrar() {
        return gestionFuncionController.exitoAlBorrar();
    }
    
    private static String gestionFuncion_falloAlBorrar() {
        return gestionFuncionController.falloAlBorrar();
    }
    
}
