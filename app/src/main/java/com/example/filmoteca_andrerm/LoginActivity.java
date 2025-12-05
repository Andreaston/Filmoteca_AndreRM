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

        EditText emailText = findViewById(R.id.editEmail);
        EditText passwordText = findViewById(R.id.editPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        TextView txtRegistro = findViewById(R.id.txtRegistro);

        //Pillamos el estado
        SharedPreferences preferences = getSharedPreferences("usuarios", MODE_PRIVATE);

        // Botón de Login
        btnLogin.setOnClickListener(v -> {
            String email = emailText.getText().toString();
            String pass = passwordText.getText().toString();

            // Recuperar los usuario
            String registerEmail = preferences.getString("registered_email", null) ;
            String registerPass = preferences.getString("registered_password", null);

            boolean login = false;
            /*
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

             */

            //Nuevas validaciones
            //Validar usuario predeterminado
            if (email.equals(USER_EMAIL) && pass.equals(USER_PASSWORD)){
                login = true;
            }
            //Validar que exista el usuario
            if (registerEmail != null && registerPass != null){
                if (email.equals(registerEmail) && pass.equals(registerPass)){
                    login = true;
                }
            }
            //Si no existe ERROR
            if (!login){
                Toast.makeText(this,getString(R.string.error_login),Toast.LENGTH_SHORT).show();
                return;
            }
            //Aplicar el estado
            getSharedPreferences("login", MODE_PRIVATE).edit().putBoolean("logeado", true).apply();

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
