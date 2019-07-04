package com.example.waterapp.model.pojo;

import com.example.waterapp.enums.Gender;

public class Person {
    private Gender gender;
    private double weight;
    private String wakeUpTime;
    private String bedTime;

    public Person(Gender gender, double weight, String wakeUpTime, String bedTime) {
        this.gender = gender;
        this.weight = weight;
        this.wakeUpTime = wakeUpTime;
        this.bedTime = bedTime;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWakeUpTime() {
        return wakeUpTime;
    }

    public void setWakeUpTime(String wakeUpTime) {
        this.wakeUpTime = wakeUpTime;
    }

    public String getBedTime() {
        return bedTime;
    }

    public void setBedTime(String bedTime) {
        this.bedTime = bedTime;
    }
}
