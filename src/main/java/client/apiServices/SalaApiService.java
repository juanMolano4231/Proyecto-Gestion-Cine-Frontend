/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package client.apiServices;

import app.models.Sala;
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
public interface SalaApiService {

    @GET("/api/salas")
    Call<List<Sala>> getSalas();

    @POST("/api/salas")
    Call<Sala> createSala(@Body Sala sala);
}
