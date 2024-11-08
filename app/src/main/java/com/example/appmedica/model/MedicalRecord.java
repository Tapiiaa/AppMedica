package com.example.appmedica.model;

public class MedicalRecord {
    private String type;
    private String description;
    private String date;

    public MedicalRecord(String type, String description, String date) {
        this.type = type;
        this.description = description;
        this.date = date;
    }


    // Getters


    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }
}