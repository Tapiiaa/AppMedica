package com.example.appmedica.userinterface;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appmedica.R;
import com.example.appmedica.database.MedicalRecordDao;
import com.example.appmedica.model.MedicalRecord;

public class EditRecordActivity extends AppCompatActivity {
    private EditText typeField, descriptionField, dateField;
    private MedicalRecordDao medicalRecordDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_record);

        typeField = findViewById(R.id.typeField);
        descriptionField = findViewById(R.id.descriptionField);
        dateField = findViewById(R.id.dateField);
        medicalRecordDao = new MedicalRecordDao(this);
    }

    public void onSaveClick(View view) {
        String type = typeField.getText().toString();
        String description = descriptionField.getText().toString();
        String date = dateField.getText().toString();

        MedicalRecord record = new MedicalRecord(type, description, date);
        medicalRecordDao.insertMedicalRecord(record);

        finish();
    }
}