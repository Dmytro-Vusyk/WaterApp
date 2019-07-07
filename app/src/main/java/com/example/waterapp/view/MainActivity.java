package com.example.waterapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;

import com.example.waterapp.R;
import com.example.waterapp.database.AppDB;
import com.example.waterapp.presenter.HomePresenter;
import com.example.waterapp.view.fragmenthome.FragmentHome;
import com.example.waterapp.view.fragmenthome.FragmentHomeAdapterOnClickHandler;

import net.danlew.android.joda.JodaTimeAndroid;

public class MainActivity extends AppCompatActivity implements FragmentHomeAdapterOnClickHandler {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JodaTimeAndroid.init(this);
        AppDB appDB = Room.databaseBuilder(getApplicationContext(),AppDB.class,"water_app_database").build();
        setContentView(R.layout.activity_main);


    }

    public void onButtonClicked(View view){
        Fragment fragment = null;

        switch (view.getId()){
            case R.id.btn_home:
                fragment = new FragmentHome();
                break;
            case R.id.btn_history:
                fragment = new FragmentHistory();
                break;
            case R.id.btn_settings:
                fragment = new FragmentSettings();
                break;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_place,fragment);
        ft.commit();
    }



    @Override
    public void onClick(long date) {

    }
}
