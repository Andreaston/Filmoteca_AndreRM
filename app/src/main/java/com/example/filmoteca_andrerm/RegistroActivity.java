package com.example.filmoteca_andrerm;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {


    protected void onCreate(Bundle x){
        //Ligamos con el layout
        super.onCreate(x);
        setContentView(R.layout.activity_registro);

        //vinculamos los elementos
        EditText userText = findViewById(R.id.userName);
        EditText emailText = findViewById(R.id.regEmail);
        EditText passText = findViewById(R.id.regPassword);
        EditText passConfirmText = findViewById(R.id.regPasswordConfirm);
        EditText tlfText = findViewById(R.id.numberTlf);
        Button botonConfirmar = findViewById(R.id.btnRegistrar);

        //Estado
        SharedPreferences preferences = getSharedPreferences("usuarios", MODE_PRIVATE);;

        //boton confirmar
        botonConfirmar.setOnClickListener(view -> {

            String user = userText.getText().toString().trim();
            String email = emailText.getText().toString().trim();
            String pass = passText.getText().toString().trim();
            String passConfirm = passConfirmText.getText().toString().trim();
            String tlf = tlfText.getText().toString().trim();
            //Error campos vacios
            if (user.isEmpty() || email.isEmpty() || pass.isEmpty() || passConfirm.isEmpty() || tlf.isEmpty() ){

                Toast.makeText(this,getString(R.string.register_error_empty),Toast.LENGTH_SHORT).show();
                return;
            }
            //Error contraseñas diferentes
            if (!passConfirm.equals(pass)){
                Toast.makeText(this,getString(R.string.error_password),Toast.LENGTH_SHORT).show();
                return;
            }
            //Email existente
            String emailGuardados = preferences.getString("registered_email",null);

            if (emailGuardados != null && email.equals(emailGuardados)){
                Toast.makeText(this, getString(R.string.register_error_user_exist),Toast.LENGTH_SHORT).show();
                return;
            }

            //Guardar usuario en el estado
            preferences.edit()
                    .putString("registered_email",email)
                    .putString("registered_password", pass)
                    .putString("registered_name", user)
                    .putString("registered_phone",tlf)
                    .apply();

            Toast.makeText(this,getString(R.string.register_ok),Toast.LENGTH_SHORT).show();

            finish();

        });


    }


}
