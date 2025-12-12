package com.example.filmoteca_andrerm;

import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapter.PeliculaAdapter;
import model.Pelicula;

public class ListaPeliculasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle x) {
        super.onCreate(x);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_listapeliculas);
        Toolbar toolbar = findViewById(R.id.toolbarPeliculas);
        RecyclerView recycler = findViewById(R.id.recyclerPeliculas);
        TextView titulo = findViewById(R.id.tituloPeliculas);

        recycler.setLayoutManager(new GridLayoutManager(this, 3));

        toolbar.setTitle(getString(R.string.film_film));
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_revert);
        toolbar.setNavigationOnClickListener(v -> {onBackPressed();});

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
                lista.add(new Pelicula(getString(R.string.movie_roma), R.drawable.poster_roma, getString(R.string.sinopsis_roma)));
                lista.add(new Pelicula(getString(R.string.movie_novedadfrente), R.drawable.poster_sinnovedad, getString(R.string.sinopsis_novedadfrente)));
                lista.add(new Pelicula(getString(R.string.movie_miresarriba), R.drawable.poster_nomires, getString(R.string.sinopsis_miresarriba)));
                lista.add(new Pelicula(getString(R.string.movie_poderperro), R.drawable.poster_poderperro, getString(R.string.sinopsis_miresarriba)));
                lista.add(new Pelicula(getString(R.string.movie_sociedadnieve), R.drawable.poster_sociedadnieve, getString(R.string.sinopsis_sociedadnieve)));
                lista.add(new Pelicula(getString(R.string.movie_irlandes), R.drawable.poster_irlandes, getString(R.string.sinopsis_irlandes)));
                lista.add(new Pelicula(getString(R.string.movie_pinocho), R.drawable.poster_pinocho, getString(R.string.sinopsis_pinocho)));
                break;
            case "HBO":
                lista.add(new Pelicula(getString(R.string.movie_dune), R.drawable.poster_dune, getString(R.string.sinopsis_dune)));
                break;
            case "Disney+":
                lista.add(new Pelicula(getString(R.string.movie_frozen), R.drawable.poster_frozen, getString(R.string.sinopsis_frozen)));
                break;
            case "Amazon Prime":
                lista.add(new Pelicula(getString(R.string.movie_manhana), R.drawable.poster_manhana, getString(R.string.sinopsis_manhana)));
                break;
            case "Apple TV":
                lista.add(new Pelicula(getString(R.string.movie_espiritu), R.drawable.poster_spirited, getString(R.string.sinopsis_espiritu)));
                break;
        }

        return lista;
    }
    /*
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // vuelve atrás
        return true;
    }

     */

}
