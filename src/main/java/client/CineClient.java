/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import app.models.Cliente;
import app.models.Funcion;
import app.models.Sala;
import app.models.Usuario;
import client.apiServices.ClienteApiService;
import client.apiServices.SalaApiService;
import client.apiServices.UsuarioApiService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author Juan José Molano Franco
 */
public class CineClient {

    private static final String BASE_URL = "http://localhost:8080";
    private static UsuarioApiService usuarioApiService;
    private static SalaApiService salaApiService;
    private static ClienteApiService clienteApiService;
    private static Retrofit retrofit;

    public CineClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        usuarioApiService = retrofit.create(UsuarioApiService.class);
        salaApiService = retrofit.create(SalaApiService.class);
        clienteApiService = retrofit.create(ClienteApiService.class);
    }

    public List<Usuario> getAllUsuarios() {
        try {
            Response<List<Usuario>> response = usuarioApiService.getAllUsuarios().execute();
            if (response.isSuccessful()) {
                List<Usuario> usuarios = response.body();
                return usuarios;
            } else {
                return null;
            }
        } catch (IOException e) {
            return null;
        }
    }

    public void createUsuario(String usu, String pin) throws Exception {
        Usuario usuario = new Cliente(usu, Long.parseLong(pin));
        try {
            Response<Usuario> response = usuarioApiService.createUsuario(usuario).execute();
            if (response.isSuccessful()) {
            } else {
                throw new Exception("El usuario no se pudo guardar, por favor inténtelo de nuevo más tarde");
            }
        } catch (IOException e) {
            throw new Exception("El usuario no se pudo guardar, por favor inténtelo de nuevo más tarde");
        }
    }

    public Usuario buscarUsuario(String user) {
        try {
            Response<Usuario> response = usuarioApiService.buscarUsuario(user).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void postUsuario(String user, Usuario usuario) throws Exception {
        try {
            Response<Usuario> response = usuarioApiService.postUsuario(user, usuario).execute();
            if (response.isSuccessful()) {
            } else {
                throw new Exception("El usuario no fue actualiado, intentelo de nuevo mas tarde.");
            }
        } catch (IOException ex) {
            throw new Exception("El usuario no fue actualiado, intentelo de nuevo mas tarde.");
        }
    }

    public List<Sala> getSalas() {
        try {
            Response<List<Sala>> response = salaApiService.getSalas().execute();
            if (response.isSuccessful()) {
                List<Sala> salas = response.body();
                return salas;
            } else {
                return null;
            }
        } catch (IOException e) {
            return null;
        }
    }

    public void createSala(int asientos) throws Exception {
        Sala sala = new Sala(asientos);
        try {
            Response<Sala> response = salaApiService.createSala(sala).execute();
            if (response.isSuccessful()) {
            } else {
                throw new Exception("La sala no se pudo guardar, por favor inténtelo de nuevo más tarde");
            }
        } catch (IOException e) {
            throw new Exception("La sala no se pudo guardar, por favor inténtelo de nuevo más tarde");
        }
    }

    public void delete(int indexSala) throws Exception {
        try {
            Response<Void> response = salaApiService.deleteSala(indexSala).execute();
            if (response.isSuccessful()) {
            } else {
                throw new Exception("La sala no se pudo borrar, por favor inténtelo de nuevo más tarde");
            }
        } catch (IOException e) {
            throw new Exception("La sala no se pudo borrar, por favor inténtelo de nuevo más tarde");
        }
    }

    public void createFuncion(Sala sala, String[] datos) throws Exception {
        try {
            Response<Void> response = salaApiService.createFuncion(sala.getId(), datos).execute();
            if (response.isSuccessful()) {
            } else {
                throw new Exception("La función no pudo guardar, por favor inténtelo de nuevo más tarde");
            }
        } catch (IOException e) {
//            throw new Exception(e.getMessage());
            e.printStackTrace();
//            throw new Exception("La función no pudo guardar, por favor inténtelo de nuevo más tarde");
        }
    }

    public List<Cliente> getAllClientes() {
        try {
            Response<List<Cliente>> response = clienteApiService.getAllClientes().execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void postCliente(String usuario, Cliente clienteData) throws Exception {
        try {
            Response<Cliente> response = clienteApiService.postCliente(usuario, clienteData).execute();
            if (!response.isSuccessful()) {
                throw new Exception("No se pudo actualizar el cliente. Inténtalo de nuevo más tarde.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("No se pudo actualizar el cliente. Inténtalo de nuevo más tarde.");
        }
    }

}
