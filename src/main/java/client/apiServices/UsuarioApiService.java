/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.apiServices;

import app.models.Usuario;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 *
 * @author Juan José Molano Franco
 */
public interface UsuarioApiService {

    @GET("/api/usuarios")
    Call<List<Usuario>> getAllUsuarios();

    @GET("/api/usuarios/{user}")
    Call<Usuario> buscarUsuario(@Path("user") String user);

    @POST("/api/usuarios/login")
    Call<Usuario> login(@Body Usuario usuario);
    
    @GET("/api/usuarios/consultarTipo/{user}")
    Call<String> consultarTipo(@Path("user") String user);
}
