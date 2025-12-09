package com.example.filmoteca_andrerm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
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
}
