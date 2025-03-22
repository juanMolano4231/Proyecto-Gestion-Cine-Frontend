/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.controllers;

import app.services.ViewGestionCineService;

/**
 *
 * @author Juan José Molano Franco
 */
public class ViewGestionCineController {

    private final ViewGestionCineService gestionCineService;
    
    public ViewGestionCineController() {
        gestionCineService = new ViewGestionCineService();
    }
    
    public Object[] verSalas() {
        return gestionCineService.verSalas();
    }
}
