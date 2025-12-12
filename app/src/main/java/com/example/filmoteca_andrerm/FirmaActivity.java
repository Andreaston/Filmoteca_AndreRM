package com.example.filmoteca_andrerm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FirmaActivity extends AppCompatActivity {

    protected void onCreate(Bundle d){
        super.onCreate(d);
        setContentView(R.layout.activity_firma);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Toolbar toolbar = findViewById(R.id.toolbarFirma);

        toolbar.setNavigationIcon(android.R.drawable.ic_menu_revert);
        toolbar.setNavigationOnClickListener(v -> {onBackPressed();});

    }
}
