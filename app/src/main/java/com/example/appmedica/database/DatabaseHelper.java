package com.example.appmedica.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2; // Incrementa la versión si ya existía la base de datos
    public static final String DATABASE_NAME = "MedicalRecords.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MEDICAL_HISTORY_TABLE = "CREATE TABLE medical_history (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "type TEXT, " +
                "description TEXT, " +
                "date TEXT)";
        db.execSQL(CREATE_MEDICAL_HISTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS medical_history");
        onCreate(db);
    }
}
