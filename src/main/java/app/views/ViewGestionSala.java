/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.views;

import javax.swing.JOptionPane;

/**
 *
 * @author Juan José Molano Franco
 */
public class ViewGestionSala {

    public int falloAlBorrar() {
        String message = "Esta sala tiene una función programada que ya vendió un tiquete, no se puede borrar";
        return JOptionPane.showConfirmDialog(null, message, "Advertencia", 
                JOptionPane.OK_CANCEL_OPTION);
    }
    
    public int exitoAlBorrar() {
        String message = "Sala borrada exitosamente";
        return JOptionPane.showConfirmDialog(null, message, "Advertencia", 
                JOptionPane.OK_CANCEL_OPTION);
    }
    
}
