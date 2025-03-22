/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.views;

import javax.swing.JOptionPane;

/**
 *
 * @author johan
 */
public class ViewLogin {

    public String pideNombreUsuario() {
        String message = "Escriba su nombre de usuario";
        return JOptionPane.showInputDialog(message);
    }

    public int usuarioInvalido() {
        String message = "El formato del nombre es invalido, no use espacios";
        return JOptionPane.showConfirmDialog(null, message, "Advertencia",
                JOptionPane.OK_CANCEL_OPTION);
    }

    public int usuarioNoEncontrado() {
        String message = "El usuario no fue encontrado, ingrese un nombre existente.";
        return JOptionPane.showConfirmDialog(null, message, "Advertencia",
                JOptionPane.OK_CANCEL_OPTION);
    }

    public String pidePin() {
        String message = "Escriba su pin";
        return JOptionPane.showInputDialog(message);
    }

    public int pinIncorrecto() {
        String message = "El pin es incorrecto.";
        return JOptionPane.showConfirmDialog(null, message, "Advertencia",
                JOptionPane.OK_CANCEL_OPTION);
    }

    public int pinInvalido() {
        String message = "El formato del pin es invalido, solo ingrese digitos";
        return JOptionPane.showConfirmDialog(null, message, "Advertencia",
                JOptionPane.OK_CANCEL_OPTION);
    }

    public int exito() {
        String message = "Inicio de sesion exitoso";
        return JOptionPane.showConfirmDialog(null, message, "Advertencia",
                JOptionPane.OK_CANCEL_OPTION);
    }

}
