/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.controllers;

import app.services.ViewBienvenidaService;

/**
 *
 * @author Juan Jose Molano Franco
 */
public class ViewBienvenidaController {
    
    private final ViewBienvenidaService service;
    
    public ViewBienvenidaController() {
        this.service = new ViewBienvenidaService();
    }
    
    public String bienvenida() {
        return service.bienvenida();
    }
}
