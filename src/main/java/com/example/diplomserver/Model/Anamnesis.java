package com.example.diplomserver.Model;

import java.io.Serializable;

public class Anamnesis implements Serializable {
    private String date;
    private String disease;
    private String type_of_assistance;
    private String result;
    private String doctor;

    public Anamnesis(String date, String disease, String type_of_assistance, String result, String doctor) {
        this.date = date;
        this.disease = disease;
        this.type_of_assistance = type_of_assistance;
        this.result = result;
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getType_of_assistance() {
        return type_of_assistance;
    }

    public void setType_of_assistance(String type_of_assistance) {
        this.type_of_assistance = type_of_assistance;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
