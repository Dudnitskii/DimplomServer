package com.example.diplomserver.Model;

import java.io.Serializable;

public class UrineAnalysis implements Serializable {
    private String date;
    private String color;
    private String erythtocytes;
    private String leukocytes;
    private String acidity;
    private String protein;
    private String glucose;
    private String dencity;

    public UrineAnalysis(String date, String color, String erythtocytes, String leukocytes, String acidity, String protein, String glucose, String dencity) {
        this.date = date;
        this.color = color;
        this.erythtocytes = erythtocytes;
        this.leukocytes = leukocytes;
        this.acidity = acidity;
        this.protein = protein;
        this.glucose = glucose;
        this.dencity = dencity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getErythtocytes() {
        return erythtocytes;
    }

    public void setErythtocytes(String erythtocytes) {
        this.erythtocytes = erythtocytes;
    }

    public String getLeukocytes() {
        return leukocytes;
    }

    public void setLeukocytes(String leukocytes) {
        this.leukocytes = leukocytes;
    }

    public String getAcidity() {
        return acidity;
    }

    public void setAcidity(String acidity) {
        this.acidity = acidity;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getGlucose() {
        return glucose;
    }

    public void setGlucose(String glucose) {
        this.glucose = glucose;
    }

    public String getDencity() {
        return dencity;
    }

    public void setDencity(String dencity) {
        this.dencity = dencity;
    }
}
