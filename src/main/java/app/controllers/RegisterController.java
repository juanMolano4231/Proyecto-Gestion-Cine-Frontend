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
        return service.usuarioInvalido();
    }
    
    public String usuarioOcupado() {
        return service.usuarioOcupado();
    }
    
    public Object[] pidePin() {
        return service.pidePin();
    }
    
    public String pinInvalido() {
        return service.pinInvalido();
    }
    
    public String exito() {
        return service.exito();
    }
}
