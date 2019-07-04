package com.example.waterapp.model.pojo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

/**
This class is implementation of one day

*/

@Entity (tableName = "daily_information")
public class DailyWaterVolume {
    
    private ArrayList<CurrentTimeWater> dailyHistory;

    @PrimaryKey
    private String date;

    public DailyWaterVolume(ArrayList<CurrentTimeWater> dailyHistory, String date) {
        this.dailyHistory = dailyHistory;
        this.date = date;
    }

    public ArrayList<CurrentTimeWater> getDailyHistory() {
        return dailyHistory;
    }

    public void setDailyHistory(ArrayList<CurrentTimeWater> dailyHistory) {
        this.dailyHistory = dailyHistory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
