package com.example.practicabonus_vj2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.practicabonus_vj2022.adapters.LibroAdapter;
import com.example.practicabonus_vj2022.database.AppDatabase;
import com.example.practicabonus_vj2022.entities.Libro;
import com.example.practicabonus_vj2022.services.LibroService;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListarLibroActivity extends AppCompatActivity {

    private RecyclerView rvLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_libro);

        AppDatabase db = AppDatabase.getInstance(this);
        List<Libro> libros = db.libroDao().getAll();

        rvLibros = findViewById(R.id.rvLibros);
        rvLibros.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvLibros.setAdapter(new LibroAdapter(libros));

    }
}