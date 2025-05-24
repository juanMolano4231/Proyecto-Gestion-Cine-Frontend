/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.apiServices;

import app.models.Cliente;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 *
 * @author johan
 */
public interface ClienteApiService {

    @POST("/api/clientes/{user}")
    Call<Cliente> postCliente(@Path("user") String user, @Body Cliente cliente, @Header("Authorization") String token);

    @POST("/api/clientes")
    Call<Cliente> createCliente(@Body Cliente cliente);

    @GET("/api/clientes/{user}")
    Call<Cliente> getClienteByUsername(@Path("user") String user, @Header("Authorization") String token);
}
