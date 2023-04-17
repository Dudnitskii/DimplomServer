package com.example.diplomserver.Model;

import java.io.Serializable;

public class Patient implements Serializable {
    private int id;
    private String fullname;
    private String birthday;
    private String sex;
    private String address;
    private String job;
    private String bloodType;
    private String allergy;

    public Patient() {}

    public Patient(int id, String fullname, String birthday, String sex, String address, String job, String bloodType, String allergy) {
        this.id = id;
        this.fullname = fullname;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.job = job;
        this.bloodType = bloodType;
        this.allergy = allergy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }
}
