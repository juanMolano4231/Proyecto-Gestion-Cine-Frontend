/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controllers;
import app.services.ViewLoginService;

/**
 *
 * @author johan
 */
public class ViewLoginController {
    
    private final ViewLoginService service;
    
    public ViewLoginController() {
        this.service = new ViewLoginService();
    }
    
    public Object[] pideNombreUsuario() {
        return service.pideNombreUsuario();
    }
    
    public String usuarioInvalido() {
        return service.usuarioInvalido();
    }
    
    public String usuarioNoEncontrado() {
        return service.usuarioNoEncontrado();
    }
    
    public Object[] pidePin() {
        return service.pidePin();
    }
    
    public String pinIncorrecto() {
        return service.pinIncorrecto();
    }
    
    public String pinInvalido() {
        return service.pinInvalido();
    }
    
    public String exito(String nombreUsuario) {
        return service.exito(nombreUsuario);
    }
}
