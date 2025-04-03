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
public class ViewCrearSala {
    
    public int exito(int n) {
        String message = "Sala número " + n + " creada exitosamente";
        return JOptionPane.showConfirmDialog(null, message, "Advertencia", 
                JOptionPane.OK_CANCEL_OPTION);
    }
}
