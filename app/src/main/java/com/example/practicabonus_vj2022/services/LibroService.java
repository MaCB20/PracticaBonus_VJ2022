package com.example.practicabonus_vj2022.services;

import com.example.practicabonus_vj2022.entities.Libro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LibroService {

    @GET("libros")
    Call<List<Libro>> get();

    @POST("libros")
    Call<Libro> create(@Body Libro libro);

    @PUT("libros/{id}")
    Call<Libro> update(@Path("id") int id, @Body Libro libro);
}
