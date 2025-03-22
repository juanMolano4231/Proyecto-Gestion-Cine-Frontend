/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.views;

import javax.swing.JOptionPane;

/**
 *
 * @author Juan Jose Molano Franco
 */
public class ViewRegister {
    public String pideNombreUsuario() {
        String message = "Registrandose, por favor elija un nombre de usuario";
        return JOptionPane.showInputDialog(message);
    }
    
    public int usuarioInvalido() {
        String message = "El formato del nombre es invalido, no use espacios";
        return JOptionPane.showConfirmDialog(null, message, "Advertencia", 
                JOptionPane.OK_CANCEL_OPTION);
    }
    
    public int usuarioOcupado() {
        String message = "El usuario ya existe, use otro nombre de usuario";
        return JOptionPane.showConfirmDialog(null, message, "Advertencia", 
                JOptionPane.OK_CANCEL_OPTION);
    }
    
    public String pidePin() {
        String message = "Elija un pin para su usuario";
        return JOptionPane.showInputDialog(message);
    }
    
    public int pinInvalido() {
        String message = "El formato del pin es invalido, solo ingrese digitos";
        return JOptionPane.showConfirmDialog(null, message, "Advertencia", 
                JOptionPane.OK_CANCEL_OPTION);
    }
    
    public int exito() {
        String message = "Usuario registrado exitosamente";
        return JOptionPane.showConfirmDialog(null, message, "Advertencia", 
                JOptionPane.OK_CANCEL_OPTION);
    }
}
