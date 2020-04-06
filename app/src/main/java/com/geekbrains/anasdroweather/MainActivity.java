package com.geekbrains.anasdroweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.geekbrains.anasdroweather.interfaces.ActivMethods;

public class MainActivity extends AppCompatActivity implements ActivMethods {

    MyData myData;
    int currentWeatPlaceId;
    int dayWeatPlaceId;
    int weekWeatPlaceId;
    CurrentWeatherFragment curWeatFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myData = MyData.getInstance();
        init();
    }

    @Override
    public void init() {
        currentWeatPlaceId = R.id.currentWeatherFrame;
        dayWeatPlaceId = R.id.dayWeatherFrame;
        weekWeatPlaceId = R.id.weekWeatherFrame;
        curWeatFragment = new CurrentWeatherFragment(currentWeatPlaceId);
        curWeatFragment.postFragment(this);
        Log.d("MainActivity", "CurrentWeatherFragment");
    }


}
