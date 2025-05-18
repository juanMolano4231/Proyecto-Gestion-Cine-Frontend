/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package client.apiServices;

import app.models.Funcion;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 *
 * @author Juan José Molano Franco
 */
public interface FuncionApiService {
    
    @PUT("/api/funciones/{idFuncion}")
    Call<Void> updateFuncion(@Path("idFuncion") int idFuncion, @Body Funcion funcion);
    
}
