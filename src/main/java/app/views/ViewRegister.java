/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.views;

import javax.swing.*;

/**
 *
 * @author Juan Jose Molano Franco
 */
public class ViewRegister {
    public String pideNombreUsuario() {
        String message = "Registrandose, por favor elija un nombre de usuario";
        return mostrarInput(message, "Nombre de Usuario");
    }
    
    public int usuarioInvalido() {
        String message = "El formato del nombre es invalido, no use espacios";
        return mostrarMensaje(message, "Advertencia");
    }
    
    public int usuarioOcupado() {
        String message = "El usuario ya existe, use otro nombre de usuario";
        return mostrarMensaje(message, "Advertencia");
    }
    
    public String pidePin() {
        String message = "Elija un pin para su usuario";
        return mostrarInput(message, "PIN");
    }
    
    public int pinInvalido() {
        String message = "El formato del pin es invalido, solo ingrese digitos";
        return mostrarMensaje(message, "Advertencia");
    }
    
    public int exito() {
        String message = "Usuario registrado exitosamente";
        return mostrarMensaje(message, "Advertencia");
    }

    private int mostrarMensaje(String message, String title) {
        JOptionPane optionPane = new JOptionPane(
            message,
            JOptionPane.WARNING_MESSAGE,
            JOptionPane.OK_CANCEL_OPTION
        );
        JDialog dialog = optionPane.createDialog(null, title);
        dialog.setSize(400, 300);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        Object selectedValue = optionPane.getValue();

        if (selectedValue instanceof Integer) {
            return (Integer) selectedValue;
        } else {
            return JOptionPane.CLOSED_OPTION;
        }
    }

    private String mostrarInput(String message, String title) {
        JOptionPane optionPane = new JOptionPane(
            message,
            JOptionPane.QUESTION_MESSAGE,
            JOptionPane.OK_CANCEL_OPTION
        );
        optionPane.setWantsInput(true);
        JDialog dialog = optionPane.createDialog(null, title);
        dialog.setSize(400, 300);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        Object inputValue = optionPane.getInputValue();

        if (inputValue == JOptionPane.UNINITIALIZED_VALUE || inputValue == null) {
            return null; // Usuario cerró el cuadro sin escribir
        } else {
            return inputValue.toString();
        }
    }
}
