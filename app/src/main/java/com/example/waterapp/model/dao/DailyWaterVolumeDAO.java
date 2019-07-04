package com.example.waterapp.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.waterapp.model.pojo.DailyWaterVolume;

import java.util.Date;

@Dao
public interface DailyWaterVolumeDAO {

    @Query("select * from daily_information where date = :day")
    DailyWaterVolume findByDay(String day);

    @Insert
    void insert(DailyWaterVolume dailyWaterVolume);

    @Update
    void update(DailyWaterVolume dailyWaterVolume);

    @Delete
    void delete(DailyWaterVolume dailyWaterVolume);



}
