package com.example.practicabonus_vj2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practicabonus_vj2022.database.AppDatabase;
import com.example.practicabonus_vj2022.entities.Libro;
import com.example.practicabonus_vj2022.services.LibroService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrearLibroActivity extends AppCompatActivity {

    EditText etTitulo, etAutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_libro);

        etTitulo = findViewById(R.id.etTitulo);
        etAutor = findViewById(R.id.etAutor);

    }

    public void guardarLibro(View view) {

        String titulo = etTitulo.getText().toString();
        String autor = etAutor.getText().toString();

        Libro libro = new Libro();
        libro.titulo = titulo;
        libro.autor = autor;

        /*Log.i("MAIN_APP", "Guardado en Bonus");*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://635789622712d01e140995f4.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LibroService service = retrofit.create(LibroService.class);
        service.create(libro).enqueue(new Callback<Libro>() {
            @Override
            public void onResponse(Call<Libro> call, Response<Libro> response) {

                Log.i("MAIN_APP", String.valueOf(response.code()));
                Toast.makeText(getApplicationContext(), "Libro registrado :)", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<Libro> call, Throwable t) {

            }
        });
    }


}