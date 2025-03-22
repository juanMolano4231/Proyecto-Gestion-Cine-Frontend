/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.services;

import app.views.ViewRegister;

/**
 *
 * @author Juan José Molano Franco
 */
public class ViewRegisterService {
    
    private final ViewRegister register;
    
    public ViewRegisterService() {
        this.register = new ViewRegister();
    }
    
    public Object[] pideNombreUsuario() {
        String input = register.pideNombreUsuario();
        if (input == null) {
            return new Object[]{"Bienvenida_bienvenida", null};
        }
        if (!nombreUsuarioValido(input)) {
            return new Object[]{"Register_usuarioInvalido", null};
        } else if (input.equals("juan1234")) {  // Usuario admin quemado
            return new Object[]{"Register_usuarioOcupado", null};
        } else {
            return new Object[]{"Register_pidePin", input};
        }
    }
    
    public String usuarioInvalido() {
        int selection = register.usuarioInvalido();
        if (selection == 0) {  // Presiona OK
            return "Register_pideNombreUsuario";
        } else if (selection == 2 || selection == -1) {  // Presiona CANCEL o cierra la ventana
            return "Bienvenida_bienvenida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }
    
    public String usuarioOcupado() {
        int selection = register.usuarioOcupado();
        if (selection == 0) {  // Presiona OK
            return "Register_pideNombreUsuario";
        } else if (selection == 2 || selection == -1) {  // Presiona CANCEL o cierra la ventana
            return "Bienvenida_bienvenida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }
    
    public Object[] pidePin() {
        String input = register.pidePin();
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return new Object[]{"Register_pinInvalido", null};
        }
        return new Object[]{"Register_exito", input};
    }
    
    public String pinInvalido() {
        int selection = register.pinInvalido();
        if (selection == 0) {  // Presiona OK
            return "Register_pidePin";
        } else if (selection == 2 || selection == -1) {  // Presiona CANCEL o cierra la ventana
            return "Bienvenida_bienvenida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }
    
    public String exito() {
        int selection = register.exito();
        if (selection == 0 || selection == 2 || selection == -1) {  // Presiona OK, CANCEL o cierra la ventana
            return "Bienvenida_bienvenida";
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
