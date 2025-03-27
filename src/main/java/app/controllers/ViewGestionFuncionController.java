/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.controllers;

import app.services.ViewGestionFuncionService;

/**
 *
 * @author Juan José Molano Franco
 */
public class ViewGestionFuncionController {
    
    private final ViewGestionFuncionService service;

    public ViewGestionFuncionController() {
        this.service = new ViewGestionFuncionService();
    }
    
    public String gestionFuncion() {
        return service.gestionFuncion();
    }
    
    public String exitoAlBorrar() {
        return service.exitoAlBorrar();
    }
    
    public String falloAlBorrar() {
        return service.falloAlBorrar();
    }
}
