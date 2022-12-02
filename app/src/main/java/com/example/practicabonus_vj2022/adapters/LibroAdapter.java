package com.example.practicabonus_vj2022.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicabonus_vj2022.R;
import com.example.practicabonus_vj2022.entities.Libro;

import java.util.List;

public class LibroAdapter extends RecyclerView.Adapter {

    List<Libro> data;

    public LibroAdapter(List<Libro> data)
    {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View itemView = inflater.inflate(R.layout.item_libros, parent, false); //Pide importar la clase R

        return new LibroViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Libro libro = data.get(position);

        TextView tvTituloLibro = holder.itemView.findViewById(R.id.tvTituloLibro);
        tvTituloLibro.setText(data.get(position).titulo);

        TextView tvAutorLibro = holder.itemView.findViewById(R.id.tvAutorLibro);
        tvAutorLibro.setText(data.get(position).autor);

        ImageView ivLibro = holder.itemView.findViewById(R.id.ivLibro);
        ivLibro.setImageResource(R.drawable.ic_launcher_background);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class LibroViewHolder extends RecyclerView.ViewHolder
    {
        public LibroViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
