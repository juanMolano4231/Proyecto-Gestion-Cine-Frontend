/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controllers;

import app.services.ViewGestionPerfilService;

/**
 *
 * @author johan
 */
public class ViewGestionPerfilController {
    
    private ViewGestionPerfilService service = new ViewGestionPerfilService();
    
    public String verPerfil() {
        return this.service.verPerfil();
    }
    
    public String verTickets() {
        return this.service.verTickets();
    }
    
    public String verFunciones() {
        return this.service.verFunciones();
    }
    
}
