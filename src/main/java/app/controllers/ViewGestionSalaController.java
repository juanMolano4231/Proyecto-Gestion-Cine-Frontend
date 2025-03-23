/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.controllers;

import app.services.ViewGestionSalaService;

/**
 *
 * @author Juan José Molano Franco
 */
public class ViewGestionSalaController {

    private final ViewGestionSalaService service;
    
    public ViewGestionSalaController() {
        service = new ViewGestionSalaService();
    }
    
    public Object[] gestionSala() {
        return service.gestionSala();
    }
    
    public String falloAlBorrar() {
        return service.falloAlBorrar();
    }
    
    public String exitoAlBorrar() {
        return service.exitoAlBorrar();
    }
    
}
