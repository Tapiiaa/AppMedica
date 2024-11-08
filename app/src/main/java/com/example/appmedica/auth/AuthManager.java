package com.example.appmedica.auth;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.appmedica.database.DatabaseHelper;

public class AuthManager {
    private DatabaseHelper dbHelper;

    public AuthManager(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Método para verificar si el usuario está registrado
    public boolean isUserRegistered(String username) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        boolean userExists = false;
        Cursor cursor = null;
        try {
            cursor = db.query("user_credentials", null, "username = ?", new String[]{username}, null, null, null);
            userExists = cursor.getCount() > 0;
        } finally {
            if (cursor != null) cursor.close();
            db.close();
        }
        return userExists;
    }

    // Método para registrar un nuevo usuario
    public void registerUser(String username, String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("INSERT INTO user_credentials (username, password) VALUES (?, ?)", new Object[]{username, password});
        db.close();
    }

    // Método para verificar el inicio de sesión del usuario
    public boolean loginUser(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user_credentials WHERE username = ? AND password = ?", new String[]{username, password});
        boolean loginSuccessful = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return loginSuccessful;
    }
}
