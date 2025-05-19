/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controllers;

import app.services.LoginService;
import app.views.ViewLogin;

/**
 *
 * @author johan
 */
public class LoginController {

    private final LoginService service;
    private final ViewLogin view;

    public LoginController() {
        this.service = new LoginService();
        this.view = new ViewLogin();
    }

    public Object[] pideNombreUsuario() {
        String input = view.pideNombreUsuario();
        return service.pideNombreUsuario(input);
    }

    public String usuarioInvalido() {
        int selection = view.usuarioInvalido();
        return service.usuarioInvalido(selection);
    }

    public String usuarioNoEncontrado() {
        int selection = view.usuarioNoEncontrado();
        return service.usuarioNoEncontrado(selection);
    }

    public Object[] pidePin() {
        String input = view.pidePin();
        return service.pidePin(input);
    }

    public String pinIncorrecto() {
        int selection = view.pinIncorrecto();
        return service.pinIncorrecto(selection);
    }

    public String pinInvalido() {
        int selection = view.pinInvalido();
        return service.pinInvalido(selection);
    }

    public String exito() {
        int selection = view.exito();
        return service.exito(selection);
    }
}
