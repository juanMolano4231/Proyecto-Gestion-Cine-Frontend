/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import app.models.Cliente;
import app.models.Funcion;
import app.models.LoginResponse;
import app.models.Sala;
import app.models.Tiquete;
import app.models.Usuario;
import client.apiServices.ClienteApiService;
import client.apiServices.FuncionApiService;
import client.apiServices.SalaApiService;
import client.apiServices.TiqueteApiService;
import client.apiServices.UsuarioApiService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
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
    private static TiqueteApiService tiqueteApiService;
    private static FuncionApiService funcionApiService;
    private static Retrofit retrofit;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CineClient.class);

    public CineClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        usuarioApiService = retrofit.create(UsuarioApiService.class);
        salaApiService = retrofit.create(SalaApiService.class);
        clienteApiService = retrofit.create(ClienteApiService.class);
        tiqueteApiService = retrofit.create(TiqueteApiService.class);
        funcionApiService = retrofit.create(FuncionApiService.class);
    }

    public LoginResponse login(String user, String pin) {
        try {
            Usuario usuario = new Usuario(user, pin);

            Response<LoginResponse> response = usuarioApiService.login(usuario).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                System.out.println("Error en login: " + response.errorBody().string());
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Sala> getSalas(String token) {
        try {
            Response<List<Sala>> response = salaApiService.getSalas("Bearer " + token).execute();
            if (response.isSuccessful()) {
                List<Sala> salas = response.body();
                return salas;
            } else {
                System.out.println("error getSalas en CineClient");
                return null;
            }
        } catch (IOException e) {
            return null;
        }
    }

    public void createSala(int asientos, String token) throws Exception {
        Sala sala = new Sala(asientos);
        try {
            Response<Sala> response = salaApiService.createSala(sala, "Bearer " + token).execute();
            if (response.isSuccessful()) {
            } else {
                throw new Exception("La sala no se pudo guardar, por favor inténtelo de nuevo más tarde");
            }
        } catch (IOException e) {
            throw new Exception("La sala no se pudo guardar, por favor inténtelo de nuevo más tarde");
        }
    }

    public void deleteSala(Sala sala, String token) throws Exception {
        try {
            Response<Void> response = salaApiService.deleteSala(sala.getId(), "Bearer " + token).execute();
            if (response.isSuccessful()) {
            } else {
                throw new Exception("La sala no se pudo borrar, por favor inténtelo de nuevo más tarde");
            }
        } catch (IOException e) {
            throw new Exception("La sala no se pudo borrar, por favor inténtelo de nuevo más tarde");
        }
    }

    public void createFuncion(Sala sala, String[] datos, String token) throws Exception {
        try {
            Response<Void> response = salaApiService.createFuncion(sala.getId(), datos, "Bearer " + token).execute();
            if (response.isSuccessful()) {
            } else {
                throw new Exception("La función no pudo guardar, por favor inténtelo de nuevo más tarde");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("La función no pudo guardar, por favor inténtelo de nuevo más tarde");
        }
    }

    public void updateSala(Sala sala, String token) throws Exception {
        try {
            Response<Sala> response = salaApiService.patchSala(sala.getId(), sala, "Bearer " + token).execute();
            if (response.isSuccessful()) {
            } else {
                System.err.println(response.errorBody().toString());
                throw new Exception("La sala no se pudo guardar");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("La sala no se pudo guardar");
        }
    }

    public void postCliente(String usuario, Cliente cliente, String token) throws Exception {
        try {
            // Enviar cliente actualizado al backend
            Response<Cliente> postResponse = clienteApiService.postCliente(usuario, cliente, "Bearer " + token).execute();
            if (!postResponse.isSuccessful()) {
                throw new Exception("No se pudo actualizar el cliente con los nuevos tiquetes.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Ocurrió un error al actualizar los tiquetes del cliente.");
        }
    }

    public void createCliente(String usu, String pin) throws Exception {
        Cliente cliente = new Cliente(usu, pin);
        try {
            Response<Cliente> response = clienteApiService.createCliente(cliente).execute();
            if (response.isSuccessful()) {
            } else {
                throw new Exception("El cliente no se pudo guardar, por favor inténtelo de nuevo más tarde");
            }
        } catch (IOException e) {
            throw new Exception("El cliente no se pudo guardar, por favor inténtelo de nuevo más tarde");
        }
    }

    public String consultarTipo(Usuario usuario, String token) {
        try {
            Response<String> response = usuarioApiService.consultarTipo(usuario.getUsuario(), "Bearer " + token).execute();
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

    public void borrarTiquete(int idFuncion, int asiento, String token) {
        try {
            Response<Void> response = tiqueteApiService.borrarTiquete(idFuncion, asiento, "Bearer " + token).execute();
            if (response.isSuccessful()) {
            } else {
                logger.warn("No se pudo borrar el tiquete con idFuncion: {} y asiento: {}", idFuncion, asiento);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateFuncion(Funcion funcion) {
        try {
            Response<Void> response = funcionApiService.updateFuncion(funcion.getId(), funcion).execute();
            if (response.isSuccessful()) {
            } else {
                logger.warn("No se pudo actualizar la funcion con id: {}", funcion.getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Boolean checkUsername(String username) {
        try {
            Response<Boolean> response = usuarioApiService.checkUsername(username).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                logger.warn("No se pudo validar el nombre de usuario: {}", username);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cliente getClienteByUsername(String username,String token) {
        try {
            Response<Cliente> response = clienteApiService.getClienteByUsername(username, "Bearer " + token).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                logger.warn("No se pudo obtener el cliente de username: {}", username);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
