/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.views;

import javax.swing.*;

/**
 *
 * @author Juan José Molano Franco
 */
public class ViewLogin {

    public String pideNombreUsuario() {
        String message = "Escriba su nombre de usuario";
        return mostrarInput(message, "Nombre de Usuario");
    }

    public int usuarioInvalido() {
        String message = "El formato del nombre es invalido, no use espacios";
        return mostrarMensaje(message, "Advertencia");
    }

    public int usuarioNoEncontrado() {
        String message = "El usuario no fue encontrado, ingrese un nombre existente.";
        return mostrarMensaje(message, "Advertencia");
    }

    public String pidePin() {
        String message = "Escriba su pin";
        return mostrarInput(message, "PIN");
    }

    public int pinIncorrecto() {
        String message = "El pin es incorrecto.";
        return mostrarMensaje(message, "Advertencia");
    }

    public int pinInvalido() {
        String message = "El formato del pin es invalido, solo ingrese digitos";
        return mostrarMensaje(message, "Advertencia");
    }

    public int exito() {
        String message = "Inicio de sesion exitoso";
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
