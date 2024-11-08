package com.example.appmedica.auth;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appmedica.R;
import com.example.appmedica.userinterface.MainActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getSharedPreferences("auth_prefs", MODE_PRIVATE);
        String savedUsername = preferences.getString("username", null);

        if (savedUsername != null) {
            // Usuario ya ha iniciado sesión anteriormente, redirigir a MainActivity
            navigateToMainActivity();
        } else {
            // Mostrar pantalla de inicio de sesión
            setContentView(R.layout.activity_login);
            usernameField = findViewById(R.id.usernameField);
        }
    }

    public void onLoginClick(View view) {
        String username = usernameField.getText().toString();

        if (username.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa un nombre de usuario", Toast.LENGTH_SHORT).show();
        } else {
            saveSession(username);
            navigateToMainActivity();
        }
    }

    private void saveSession(String username) {
        SharedPreferences preferences = getSharedPreferences("auth_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", username);
        editor.apply();
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

