package com.example.waterapp.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.waterapp.model.pojo.CurrentTimeRecord;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CurrentTimeRecordDAO {


    @Query("select * from time_record where time >= :startOfTheDay and time <= :endOfTheDay order by time asc")
    List<CurrentTimeRecord> getDailyHistory(long startOfTheDay, long endOfTheDay);

    @Insert
    void insert(CurrentTimeRecord record);

    @Update
    void update(CurrentTimeRecord record);

    @Delete
    void delete(CurrentTimeRecord record);


}
