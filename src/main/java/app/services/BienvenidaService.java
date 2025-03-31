/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.services;

import app.frames.FrameBienvenida;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Juan José Molano Franco
 */
public class BienvenidaService {

    public String bienvenida(int seleccion) {
        switch (seleccion) {
            case 0:  // Se cierra el frame con la X
            case 1:  // Cerrar
                return "salida";
            case 2:  // Iniciar sesión
                return "Login_pideNombreUsuario";
            case 3:  // Iniciar sesión
                return "Register_pideNombreUsuario";
            default:  // Botón no configurado
                throw new Error("Botón no configurado");
        }
    }
}
