package com.example.filmoteca_andrerm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String USER_EMAIL = "usuario@ejemplo.com";
    private static final String USER_PASSWORD = "1234";

    @Override
    protected void onCreate(Bundle x){
        super.onCreate(x);
        setContentView(R.layout.activity_login);

        EditText email = findViewById(R.id.editEmail);
        EditText password = findViewById(R.id.editPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        TextView txtRegistro = findViewById(R.id.txtRegistro);

        // Botón de Login
        btnLogin.setOnClickListener(v -> {
            String emailText = email.getText().toString();
            String passText = password.getText().toString();

            // Validación
            if (!emailText.equals(USER_EMAIL)) {
                Toast.makeText(this, getString(R.string.error_email), Toast.LENGTH_SHORT).show();
                return;
            }

            if (!passText.equals(USER_PASSWORD)) {
                Toast.makeText(this, getString(R.string.error_password), Toast.LENGTH_SHORT).show();
                return;
            }

            // Login correcto → guardar estado
            SharedPreferences prefs = getSharedPreferences("login", MODE_PRIVATE);
            prefs.edit().putBoolean("logeado", true).apply();

            // Ir a la pantalla de plataformas
            Intent i = new Intent(this, ListaPlataformasActivity.class);
            startActivity(i);
            finish(); // ← Importante
        });

        // Enlace a registro
        txtRegistro.setOnClickListener(v -> {
            Intent i = new Intent(this, RegistroActivity.class);
            startActivity(i);
        });



    }


}
