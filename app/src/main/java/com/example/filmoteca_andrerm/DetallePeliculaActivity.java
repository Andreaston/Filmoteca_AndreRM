package com.example.filmoteca_andrerm;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
//import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetallePeliculaActivity extends AppCompatActivity {

    protected void onCreate(Bundle x){

        super.onCreate(x);
        setContentView(R.layout.activity_detalle_pelicula);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ImageView imgPoster = findViewById(R.id.imgPosterGrande);
        TextView txtTitulo = findViewById(R.id.txtTituloDetalle);
        TextView txtSinopsis = findViewById(R.id.txtSinopsis);
        Toolbar toolbar = findViewById(R.id.toolbarDetallesPeliculas);

        toolbar.setTitle(getString(R.string.film_film));
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_revert);
        toolbar.setNavigationOnClickListener(v -> {onBackPressed();});

        String titulo = getIntent().getStringExtra("titulo");
        int posterResId = getIntent().getIntExtra("poster", 0);
        String sinopsis = getIntent().getStringExtra("sinopsis");

        imgPoster.setImageResource(posterResId);
        txtTitulo.setText(titulo);
        txtSinopsis.setText(sinopsis != null ? sinopsis : "Sinopsis no disponible");


    }

}
