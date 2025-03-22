/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.controllers;

import java.util.ArrayList;
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
@RequestMapping("/api/test")
public class TestController {
    
    @Autowired
    public TestController() {
    }

    @GetMapping
    public ResponseEntity<ArrayList> getAllUsuarios() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("primero");
        strings.add("segundo");
        strings.add("tercero");
        return new ResponseEntity<>(strings, HttpStatus.OK);
    }
}
