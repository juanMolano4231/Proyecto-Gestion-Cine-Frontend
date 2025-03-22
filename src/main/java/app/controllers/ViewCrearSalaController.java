/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.controllers;

import app.services.ViewCrearSalaService;

/**
 *
 * @author Juan José Molano Franco
 */
public class ViewCrearSalaController {

    private final ViewCrearSalaService service;
    
    public ViewCrearSalaController() {
        this.service = new ViewCrearSalaService();
    }
    
    public Object[] crearSala() {
        return service.crearSala();
    }
    
    public String exito() {
        return service.exito();
    }
    
}
