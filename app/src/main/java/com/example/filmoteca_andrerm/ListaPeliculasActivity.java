package com.example.filmoteca_andrerm;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapter.PeliculaAdapter;
import model.Pelicula;

public class ListaPeliculasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listapeliculas);

        RecyclerView recycler = findViewById(R.id.recyclerPeliculas);
        recycler.setLayoutManager(new GridLayoutManager(this, 3));

        TextView titulo = findViewById(R.id.tituloPeliculas);

        // Recibimos la plataforma desde el Intent
        String plataforma = getIntent().getStringExtra("plataforma");
        titulo.setText(plataforma);

        ArrayList<Pelicula> listaPeliculas = obtenerPeliculas(plataforma);

        PeliculaAdapter adapter = new PeliculaAdapter(listaPeliculas, this);
        recycler.setAdapter(adapter);
    }

    private ArrayList<Pelicula> obtenerPeliculas(String plataforma) {

        ArrayList<Pelicula> lista = new ArrayList<>();

        switch (plataforma) {

            case "Netflix":
                lista.add(new Pelicula(getString(R.string.movie_roma), R.drawable.poster_roma));
                lista.add(new Pelicula("Sin novedad en el frente", R.drawable.poster_sinnovedad));
                lista.add(new Pelicula("No mires arriba", R.drawable.poster_nomires));
                lista.add(new Pelicula("El poder del perro", R.drawable.poster_poderperro));
                lista.add(new Pelicula("La sociedad de la nieve", R.drawable.poster_sociedadnieve));
                lista.add(new Pelicula("El irlandés", R.drawable.poster_irlandes));
                lista.add(new Pelicula("Pinocho", R.drawable.poster_pinocho));
                break;

            case "HBO":
                lista.add(new Pelicula("Dune: Parte Dos", R.drawable.poster_dune));
                break;

            case "Disney+":
                lista.add(new Pelicula("Frozen II", R.drawable.poster_frozen));
                break;

            case "Amazon Prime":
                lista.add(new Pelicula("Mañana es hoy", R.drawable.poster_manhana));
                break;

            case "Apple TV":
                lista.add(new Pelicula("Spirited", R.drawable.poster_spirited));
                break;
        }

        return lista;
    }
}
