package com.example.waterapp.presenter;

import com.example.waterapp.App;
import com.example.waterapp.model.pojo.CurrentTimeRecord;
import com.example.waterapp.utils.TimeUtils;
import com.example.waterapp.view.fragmenthome.FragmentHome;
import com.example.waterapp.view.fragmenthome.FragmentHomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomePresenter {

    private static HomePresenter instance;

    public static HomePresenter getInstance() {
        if (instance == null) {
            instance = new HomePresenter();
        }
        return instance;
    }

    //TODO toast massage and choice of water count
    public void addWater() {
        //TODO make with variable
        int waterVolume = 200;

        CurrentTimeRecord currentTimeRecord = new CurrentTimeRecord(TimeUtils.getCurrentTime(), waterVolume);

        App.getInstance().getDatabase().dailyWaterVolumeDAO().insert(currentTimeRecord);

    }

    public List<CurrentTimeRecord> getDailyHistory() {

        long start = TimeUtils.getStartOfCurrentDay();
        long end = TimeUtils.getEndOfCurrentDay();

        List<CurrentTimeRecord> result = App.getInstance().getDatabase().dailyWaterVolumeDAO().getDailyHistory(start, end);

        return result;

    }


}
