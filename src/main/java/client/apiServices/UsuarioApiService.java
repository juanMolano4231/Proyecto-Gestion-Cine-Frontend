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

/**
 *
 * @author Juan José Molano Franco
 */
public interface UsuarioApiService {
    @GET("/api/usuarios")
    Call<List<Usuario>> getAllUsuarios();

    @POST("/api/usuarios")
    Call<Usuario> createUsuario(@Body Usuario usuario);

}
