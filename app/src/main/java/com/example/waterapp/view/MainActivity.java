package com.example.waterapp.view;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import com.example.waterapp.R;
import com.example.waterapp.database.AppDB;
import com.example.waterapp.view.fragmenthome.FragmentHome;
import com.example.waterapp.view.fragmenthome.FragmentHomeAdapterOnClickHandler;

import net.danlew.android.joda.JodaTimeAndroid;

public class MainActivity extends AppCompatActivity implements FragmentHomeAdapterOnClickHandler {

    FragmentHome fragmentHome;
    FragmentHistory fragmentHistory;
    FragmentSettings fragmentSettings;
    final static String TAG_1 = "FRAGMENT_HOME";
    final static String TAG_2 = "FRAGMENT_HISTORY";
    final static String TAG_3 = "FRAGMENT_SETTINGS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JodaTimeAndroid.init(this);
        AppDB appDB = Room.databaseBuilder(getApplicationContext(), AppDB.class, "water_app_database").build();
        setContentView(R.layout.activity_main);


    }

    public void onButtonClicked(View view) {
        boolean isCreated = false;
        Fragment fragment = null;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.btn_home:
                fragment = new FragmentHome();
                ft.replace(R.id.fragment_place, fragment).commit();
                isCreated = true;
                break;
            case R.id.btn_history:
                fragment = new FragmentHistory();
                ft.replace(R.id.fragment_place, fragment).commit();
                isCreated = true;
                break;
            case R.id.btn_settings:
                fragment = new FragmentSettings();
                ft.replace(R.id.fragment_place, fragment).commit();
                isCreated = true;
                break;
        }

        if (!isCreated) {
            if (Build.VERSION.SDK_INT >= 26) {
                ft.setReorderingAllowed(false);
            }

            ft.add(R.id.fragment_place, fragment);
            ft.commit();
        }
    }


    @Override
    public void onClick(long date) {

    }
}
