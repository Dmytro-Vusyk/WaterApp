package com.example.waterapp.presenter;

import com.example.waterapp.model.pojo.CurrentTimeWater;
import com.example.waterapp.model.pojo.DailyWaterVolume;

import net.danlew.android.joda.DateUtils;
import net.danlew.android.joda.JodaTimeAndroid;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

public class HomePresenter {


    private static HomePresenter instance;

    public static synchronized HomePresenter getInstance() {
        if (instance == null) {
            instance = new HomePresenter();
        }
        return instance;
    }

    //TODO toast massage and choice of water count
    public void addWater() {
        //TODO make with variable
        int waterVolume = 200;

        DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm");
        DateTime now = DateTime.now();
        String currentTime = fmt.print(now);

        CurrentTimeWater currentTimeWater = new CurrentTimeWater(currentTime, waterVolume);


    }

}
