package com.example.diplomserver.Model;

import java.io.Serializable;

public class Request implements Serializable {
    private String doctor;
    private String medicine;
    private String description;
    private String status;

    public Request(String doctor, String medicine, String description, String status) {
        this.doctor = doctor;
        this.medicine = medicine;
        this.description = description;
        this.status = status;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
