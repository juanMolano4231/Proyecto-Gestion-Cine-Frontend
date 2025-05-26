/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.apiServices;

import app.models.LoginResponse;
import app.models.Usuario;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 *
 * @author Juan José Molano Franco
 */
public interface UsuarioApiService {

    @POST("/api/usuarios/login")
    Call<LoginResponse> login(@Body Usuario usuario);

    @GET("/api/usuarios/consultarTipo/{user}")
    Call<String> consultarTipo(@Path("user") String user, @Header("Authorization") String token);
    
    @GET("/api/usuarios/checkUsername/{user}")
    Call<Boolean> checkUsername(@Path("user") String user);

}
