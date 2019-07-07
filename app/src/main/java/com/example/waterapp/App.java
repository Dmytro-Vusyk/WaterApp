package com.example.waterapp;

import android.app.Application;

import androidx.room.Room;

import com.example.waterapp.database.AppDB;

public class App extends Application {

    public static App instance;

    private AppDB database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = AppDB.getInstance(this);
    }

    public static App getInstance() {
        return instance;
    }

    public AppDB getDatabase() {
        return database;
    }
}