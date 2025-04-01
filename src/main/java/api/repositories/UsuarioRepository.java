/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package api.repositories;

import app.models.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan José Molano Franco
 */

@Repository
public class UsuarioRepository {
    private final List<Usuario> baseDeDatos = new ArrayList<>();

    public void save(Usuario usuario) {
        baseDeDatos.add(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return baseDeDatos;
    }

    public Usuario findByUser(String user) {
        for (Usuario usuario : baseDeDatos) {
            if(usuario.getUsuario().equals(user)) {
                return usuario;
            }
        }
        return null;
    }

}
