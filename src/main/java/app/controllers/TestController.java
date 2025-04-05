/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.controllers;

import app.services.TestService;

/**
 *
 * @author Juan José Molano Franco
 */
public class TestController {
    
    private final TestService service;
    
    public TestController() {
        this.service = new TestService();
    }

    public String botones() {
        return service.botones();
    }
    
}
