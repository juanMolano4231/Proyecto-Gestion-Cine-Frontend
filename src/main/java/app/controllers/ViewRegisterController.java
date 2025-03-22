/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.controllers;

import app.services.ViewRegisterService;

/**
 *
 * @author Juan Jose Molano Franco
 */
public class ViewRegisterController {
    
    private final ViewRegisterService service;
    
    public ViewRegisterController() {
        this.service = new ViewRegisterService();
    }
    
    public Object[] pideNombreUsuario() {
        return service.pideNombreUsuario();
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
