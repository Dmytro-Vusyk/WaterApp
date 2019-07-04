package com.example.waterapp.model.pojo;

import java.util.Date;

/**
 * This class is implementation of one time drink history
 */
//TODO rename class
public class CurrentTimeWater {

    private String currentTime;
    private int waterVolume;

    public CurrentTimeWater(String currentTime, int waterVolume) {
        this.currentTime = currentTime;
        this.waterVolume = waterVolume;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public int getWaterVolume() {
        return waterVolume;
    }

    public void setWaterVolume(int waterVolume) {
        this.waterVolume = waterVolume;
    }
}
