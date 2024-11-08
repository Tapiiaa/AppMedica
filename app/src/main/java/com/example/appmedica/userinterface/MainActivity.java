package com.example.appmedica.userinterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appmedica.R;
import com.example.appmedica.database.MedicalRecordDao;
import com.example.appmedica.model.MedicalRecord;
import com.example.appmedica.model.MedicalRecordAdapter;


import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MedicalRecordDao medicalRecordDao;
    private RecyclerView recordsRecyclerView;
    private MedicalRecordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        medicalRecordDao = new MedicalRecordDao(this);
        recordsRecyclerView = findViewById(R.id.recordsRecyclerView);
        recordsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializar el adaptador y asignarlo al RecyclerView
        adapter = new MedicalRecordAdapter();
        recordsRecyclerView.setAdapter(adapter);

        // Cargar los registros iniciales
        loadRecords();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Recargar los registros cada vez que se vuelve a esta actividad
        loadRecords();
    }

    private void loadRecords() {
        // Obtener la lista de registros médicos desde la base de datos
        List<MedicalRecord> records = medicalRecordDao.getAllRecords();
        // Actualizar el adaptador con la nueva lista de registros
        adapter.setRecords(records);
    }

    public void onAddRecordClick(View view) {
        // Redirige a EditRecordActivity para añadir un nuevo registro
        Intent intent = new Intent(this, EditRecordActivity.class);
        startActivity(intent);
    }
}
