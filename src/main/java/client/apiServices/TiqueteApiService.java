/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package client.apiServices;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 *
 * @author Juan José Molano Franco
 */
public interface TiqueteApiService {
    
    @DELETE("/api/tiquetes/{idFuncion}/{asiento}")
    Call<Void> borrarTiquete(@Path("idFuncion") int idFuncion, @Path("asiento") int asiento, @Header("Authorization") String token);

}
