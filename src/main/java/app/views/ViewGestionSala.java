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
public class ViewGestionSala {

    public int falloAlBorrar() {
        String message = "Esta sala tiene una funcion programada que ya vendio un tiquete, no se puede borrar";
        return mostrarMensaje(message, "Advertencia");
    }
    
    public int exitoAlBorrar() {
        String message = "Sala borrada exitosamente";
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
}
