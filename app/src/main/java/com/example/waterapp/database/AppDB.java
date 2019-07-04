package com.example.waterapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.waterapp.model.dao.DailyWaterVolumeDAO;
import com.example.waterapp.model.pojo.DailyWaterVolume;

@Database(entities = {DailyWaterVolume.class}, version = 1)
public abstract class AppDB extends RoomDatabase {

   public abstract DailyWaterVolumeDAO dailyWaterVolumeDAO();

}
