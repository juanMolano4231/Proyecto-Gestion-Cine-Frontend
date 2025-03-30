/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package api.services;

import api.repositories.UsuarioRepository;
import app.models.Administrador;
import app.models.Cliente;
import app.models.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan José Molano Franco
 */

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
        initSampleData();
    }

    private void initSampleData() {
        Usuario juan = new Administrador("juan1234", 1234);
        Usuario johan = new Cliente("johan1234", 1234);
        save(juan);
        save(johan);
    }

    private void save(Usuario usuario) {
        repository.save(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return repository.getAllUsuarios();
    }
}
