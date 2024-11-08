package com.example.appmedica.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appmedica.R;
import com.example.appmedica.model.MedicalRecord;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordAdapter extends RecyclerView.Adapter<MedicalRecordAdapter.MedicalRecordViewHolder> {
    private List<MedicalRecord> records = new ArrayList<>();

    @NonNull
    @Override
    public MedicalRecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medical_record, parent, false);
        return new MedicalRecordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicalRecordViewHolder holder, int position) {
        MedicalRecord record = records.get(position);
        holder.bind(record);
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    public void setRecords(List<MedicalRecord> records) {
        this.records = records;
        notifyDataSetChanged();
    }

    class MedicalRecordViewHolder extends RecyclerView.ViewHolder {
        private TextView typeTextView;
        private TextView descriptionTextView;
        private TextView dateTextView;

        public MedicalRecordViewHolder(@NonNull View itemView) {
            super(itemView);
            typeTextView = itemView.findViewById(R.id.typeTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
        }

        public void bind(MedicalRecord record) {
            // Asigna los valores ingresados por el usuario a cada TextView
            typeTextView.setText(record.getType());
            descriptionTextView.setText(record.getDescription());
            dateTextView.setText(record.getDate());
        }
    }
}


