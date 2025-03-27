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
public class ViewGestionFuncion {
    
    public int falloAlBorrar() {
        String message = "La función ya tiene asientos ocupados";
        return JOptionPane.showConfirmDialog(null, message, "Advertencia", 
                JOptionPane.OK_CANCEL_OPTION);
    }
    
    public int exitoAlBorrar() {
        String message = "Función borrada exitosamente";
        return JOptionPane.showConfirmDialog(null, message, "Advertencia", 
                JOptionPane.OK_CANCEL_OPTION);
    }
}
