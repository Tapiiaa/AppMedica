package com.example.appmedica.auth;

import android.content.Intent;
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
        setContentView(R.layout.activity_login);

        usernameField = findViewById(R.id.usernameField);
    }

    public void onLoginClick(View view) {
        String username = usernameField.getText().toString();

        if (username.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa un nombre de usuario", Toast.LENGTH_SHORT).show();
        } else {
            navigateToMainActivity();
        }
    }

    private void navigateToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

