package app.controllers;

import app.models.Sala;
import app.models.Usuario;
import app.services.ViewGestionPerfilService;
import java.util.List;

public class ViewGestionPerfilController {

    private final ViewGestionPerfilService service = new ViewGestionPerfilService();

    public String verPerfil(Usuario usuario) {
        return service.verPerfil(usuario);
    }

    public String verTickets(Usuario usuario) {
        return service.verTickets(usuario);
    }

    public String verFunciones(Usuario usuario, List<Sala> salas) {
        return service.verFunciones(usuario, salas);
    }
}
