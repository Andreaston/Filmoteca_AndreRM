package com.example.filmoteca_andrerm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AyudaActivity extends AppCompatActivity {

    protected void onCreate(Bundle c){
        super.onCreate(c);
        setContentView(R.layout.activity_ayuda);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Toolbar toolbar = findViewById(R.id.toolbarAyuda);

        toolbar.setNavigationIcon(android.R.drawable.ic_menu_revert);
        toolbar.setNavigationOnClickListener(v -> {onBackPressed();});


    }

}
