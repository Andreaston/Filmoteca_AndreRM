package com.example.filmoteca_andrerm;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle x){
        super.onCreate(x);

        // Quitar la barra de título
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Si hay actionBar, sacalo
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        // Vincular el layout XML
        setContentView(R.layout.activity_main);

        // Referenciar el botón
        Button btnEntrar = findViewById(R.id.btnEntrar);

        // Acción al pulsar el botón: abrir LoginActivity
        btnEntrar.setOnClickListener(v -> {
            //Origen - Destino
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            //Incialo
            startActivity(intent);
        });


    }



}
