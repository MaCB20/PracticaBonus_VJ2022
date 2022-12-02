package com.example.practicabonus_vj2022.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.practicabonus_vj2022.daos.LibroDao;
import com.example.practicabonus_vj2022.entities.Libro;

@Database(entities = {Libro.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract LibroDao libroDao();
    public static AppDatabase getInstance(Context context)
    {
        return Room.databaseBuilder(context, AppDatabase.class, "bonus2022_db")
                .allowMainThreadQueries()
                .build();
    }
}
