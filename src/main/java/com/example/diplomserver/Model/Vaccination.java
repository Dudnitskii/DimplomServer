package com.example.diplomserver.Model;

import java.io.Serializable;

public class Vaccination implements Serializable {
    private String date;
    private String name_of_vaccination;
    private String medicine;
    private String dose;
    private String batch;
    private String result;

    public Vaccination(String date, String name_of_vaccination, String medicine, String dose, String batch, String result) {
        this.date = date;
        this.name_of_vaccination = name_of_vaccination;
        this.medicine = medicine;
        this.dose = dose;
        this.batch = batch;
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName_of_vaccination() {
        return name_of_vaccination;
    }

    public void setName_of_vaccination(String name_of_vaccination) {
        this.name_of_vaccination = name_of_vaccination;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
