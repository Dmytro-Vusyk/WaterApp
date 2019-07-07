package com.example.waterapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.waterapp.model.dao.CurrentTimeRecordDAO;
import com.example.waterapp.model.pojo.CurrentTimeRecord;

@Database(entities = {CurrentTimeRecord.class}, version = 1)
public abstract class AppDB extends RoomDatabase {

   public abstract CurrentTimeRecordDAO dailyWaterVolumeDAO();

   private static AppDB instance;

   public static AppDB getInstance(Context context) {
      if (instance == null) {
         instance = Room.databaseBuilder(context.getApplicationContext(),
                 AppDB.class, "water_app_database")
                 .fallbackToDestructiveMigration()
                 .allowMainThreadQueries()
                 .build();
      }
      return instance;
   }

}
