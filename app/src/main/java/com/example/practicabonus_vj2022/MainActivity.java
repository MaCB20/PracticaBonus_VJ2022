package com.example.practicabonus_vj2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {

    RecyclerView rvLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*AppDatabase db = AppDatabase.getInstance(this);*/

        /*List<Libro> libros = db.libroDao().getAll();
        Log.i("MAIN_APP", new Gson().toJson(libros));*/
    }

    public void crearLibro(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CrearLibroActivity.class);
        startActivity(intent);
    }

    public void listarLibro(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ListarLibroActivity.class);
        startActivity(intent);
    }

    public void sincronizarBD(View view)
    {
        AppDatabase db = AppDatabase.getInstance(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://635789622712d01e140995f4.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LibroService service = retrofit.create(LibroService.class);
        service.get().enqueue(new Callback<List<Libro>>() {
            @Override
            public void onResponse(Call<List<Libro>> call, Response<List<Libro>> response) {

                List<Libro> data = response.body();
                for(int i=0; i<data.size(); i++){
                    Libro aux = data.get(i);
                    Libro aux2 = db.libroDao().find(aux.id);
                    if(aux2 != null){
                        db.libroDao().update(aux);
                    } else {
                        db.libroDao().create(aux);
                    }
                }

                List<Libro> libros = db.libroDao().getAll();
                Log.i("MAIN_APP", new Gson().toJson(libros));

                Toast.makeText(getApplicationContext(), "Se sincronizó correctamente", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Libro>> call, Throwable t) {

            }
        });
    }
}