package com.example.filmoteca_andrerm;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapter.PlataformaAdapter;
import model.Plataformas;

public class ListaPlataformasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaplataformas);
        /*
        Toolbar toolbar = findViewById(R.id.toolbarPlataformas);
        setSupportActionBar(toolbar);

         */

        RecyclerView recycler = findViewById(R.id.recyclerPlataformas);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Plataformas> lista = new ArrayList<>();
        lista.add(new Plataformas("Netflix", R.drawable.netflix));
        lista.add(new Plataformas("HBO", R.drawable.hbo));
        lista.add(new Plataformas("Disney+", R.drawable.disney));
        lista.add(new Plataformas("Amazon Prime", R.drawable.prime));
        lista.add(new Plataformas("Apple TV", R.drawable.apple));

        PlataformaAdapter adapter = new PlataformaAdapter(lista, this);
        recycler.setAdapter(adapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_plataformas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuAyuda) {
            Intent intentAyuda = new Intent(ListaPlataformasActivity.this, AyudaActivity.class);
            startActivity(intentAyuda);
            return true;
        } else if (id == R.id.menuAcercaDe) {
            Intent intentFirma = new Intent(ListaPlataformasActivity.this, FirmaActivity.class);
            startActivity(intentFirma);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
