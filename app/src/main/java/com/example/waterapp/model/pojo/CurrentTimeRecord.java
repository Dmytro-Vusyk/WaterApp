package com.example.waterapp.model.pojo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * This class is implementation of one time drink history
 */
//TODO rename class
@Entity(tableName = "time_record")
public class CurrentTimeRecord {

    @PrimaryKey
    @NonNull
    private long time;

    @ColumnInfo(name = "water_volume")
    private int waterVolume;

    public CurrentTimeRecord(long time, int waterVolume) {
        this.time = time;
        this.waterVolume = waterVolume;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getWaterVolume() {
        return waterVolume;
    }

    public void setWaterVolume(int waterVolume) {
        this.waterVolume = waterVolume;
    }
}
