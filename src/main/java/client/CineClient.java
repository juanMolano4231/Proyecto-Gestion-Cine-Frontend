/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package client;

import app.models.Usuario;
import client.apiServices.UsuarioApiService;
import java.io.IOException;
import java.util.List;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author Juan José Molano Franco
 */
public class CineClient {
    private static final String BASE_URL = "http://localhost:8080";
    private static UsuarioApiService apiService;
    private static Retrofit retrofit;

    public CineClient() {
        retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        apiService = retrofit.create(UsuarioApiService.class);
    }
    
//    public static void main(String[] args) {
//        Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//
//        apiService = retrofit.create(UsuarioApiService.class);
//    }
    
    public List<Usuario> getAllUsuarios() {
        try {
            Response<List<Usuario>> response = apiService.getAllUsuarios().execute();
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
}
