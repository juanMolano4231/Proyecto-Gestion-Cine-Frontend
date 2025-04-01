/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package api.controllers;

import api.services.SalaService;
import app.models.Sala;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan José Molano Franco
 */

@RestController
@RequestMapping("/api/salas")
public class SalaController {
    
    private final SalaService service;

    @Autowired
    public SalaController(SalaService service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<Sala>> getSalas() {
        List<Sala> Salas = service.getSalas();
        return new ResponseEntity<>(Salas, HttpStatus.OK);
    }
}
