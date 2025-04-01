/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controllers;

import app.services.RegisterService;
import app.views.ViewRegister;

/**
 *
 * @author Juan Jose Molano Franco
 */
public class RegisterController {

    private final RegisterService service;
    private final ViewRegister view;

    public RegisterController() {
        service = new RegisterService();
        view = new ViewRegister();
    }

    public Object[] pideNombreUsuario() {
        String nombreUsuario = view.pideNombreUsuario();
        return service.pideNombreUsuario(nombreUsuario);
    }

    public String usuarioInvalido() {
        int seleccion = view.usuarioInvalido();
        return service.usuarioInvalido(seleccion);
    }

    public String usuarioOcupado() {
        int seleccion = view.usuarioOcupado();
        return service.usuarioOcupado(seleccion);
    }

    public Object[] pidePin() {
        String input = view.pidePin();
        return service.pidePin(input);
    }

    public String pinInvalido() {
        int seleccion = view.pinInvalido();
        return service.pinInvalido(seleccion);
    }

    public String exito(String usu, String pin) {
        int seleccion = view.exito();
        System.out.println("pasa");
        return service.exito(seleccion, usu, pin);
    }
}
