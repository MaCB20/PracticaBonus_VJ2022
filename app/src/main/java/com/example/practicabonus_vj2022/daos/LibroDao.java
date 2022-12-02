package com.example.practicabonus_vj2022.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.practicabonus_vj2022.entities.Libro;

import java.util.List;

@Dao
public interface LibroDao {

    @Query("SELECT * FROM Libros")
    List<Libro> getAll();

    @Query("SELECT * FROM Libros where id = :id")
    Libro find(int id);

    @Insert
    void create(Libro libro);

    @Update
    void update(Libro libro);
}
