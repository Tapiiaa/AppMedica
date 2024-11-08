package com.example.appmedica.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.appmedica.model.MedicalRecord;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordDao {
    private DatabaseHelper dbHelper;

    public MedicalRecordDao(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void insertRecord(MedicalRecord record) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("type", record.getType());
        values.put("description", record.getDescription());
        values.put("date", record.getDate());

        db.insert("medical_history", null, values);
        db.close();
    }

    public void insertMedicalRecord(MedicalRecord record) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("type", record.getType());
        values.put("description", record.getDescription());
        values.put("date", record.getDate());

        db.insert("medical_history", null, values);
        db.close();
    }


    public List<MedicalRecord> getAllRecords() {
        List<MedicalRecord> records = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query("medical_history", null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex("id");
            int typeIndex = cursor.getColumnIndex("type");
            int descriptionIndex = cursor.getColumnIndex("description");
            int dateIndex = cursor.getColumnIndex("date");

            do {
                int id = cursor.getInt(idIndex);
                String type = cursor.getString(typeIndex);
                String description = cursor.getString(descriptionIndex);
                String date = cursor.getString(dateIndex);

                MedicalRecord record = new MedicalRecord(type, description, date);
                records.add(record);
            } while (cursor.moveToNext());

            cursor.close();
        }
        db.close();
        return records;
    }
}
