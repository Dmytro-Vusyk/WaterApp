package com.example.waterapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.waterapp.model.dao.DailyWaterVolumeDAO;
import com.example.waterapp.model.pojo.DailyWaterVolume;

@Database(entities = {DailyWaterVolume.class}, version = 1)
public abstract class AppDB extends RoomDatabase {

   public abstract DailyWaterVolumeDAO dailyWaterVolumeDAO();

   private static AppDB instance;

   public static synchronized AppDB getInstance(Context context) {
      if (instance == null) {
         instance = Room.databaseBuilder(context.getApplicationContext(),
                 AppDB.class, "water_app_db.db")
                 .fallbackToDestructiveMigration()
                 .allowMainThreadQueries()
                 .build();
      }
      return instance;
   }

}
