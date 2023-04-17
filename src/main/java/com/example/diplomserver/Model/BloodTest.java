package com.example.diplomserver.Model;

import java.io.Serializable;

public class BloodTest implements Serializable {
    private String hemoglobin;
    private String hematocrit;
    private String erythrocytes;
    private String platelets;
    private String leukocytes;
    private String mcv;
    private String rdw;
    private String mch;

    public BloodTest(String hemoglobin, String hematocrit, String erythrocytes, String platelets, String leukocytes, String mcv, String rdw, String mch) {
        this.hemoglobin = hemoglobin;
        this.hematocrit = hematocrit;
        this.erythrocytes = erythrocytes;
        this.platelets = platelets;
        this.leukocytes = leukocytes;
        this.mcv = mcv;
        this.rdw = rdw;
        this.mch = mch;
    }

    public String getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(String hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public String getHematocrit() {
        return hematocrit;
    }

    public void setHematocrit(String hematocrit) {
        this.hematocrit = hematocrit;
    }

    public String getErythrocytes() {
        return erythrocytes;
    }

    public void setErythrocytes(String erythrocytes) {
        this.erythrocytes = erythrocytes;
    }

    public String getPlatelets() {
        return platelets;
    }

    public void setPlatelets(String platelets) {
        this.platelets = platelets;
    }

    public String getLeukocytes() {
        return leukocytes;
    }

    public void setLeukocytes(String leukocytes) {
        this.leukocytes = leukocytes;
    }

    public String getMcv() {
        return mcv;
    }

    public void setMcv(String mcv) {
        this.mcv = mcv;
    }

    public String getRdw() {
        return rdw;
    }

    public void setRdw(String rdw) {
        this.rdw = rdw;
    }

    public String getMch() {
        return mch;
    }

    public void setMch(String mch) {
        this.mch = mch;
    }
}
