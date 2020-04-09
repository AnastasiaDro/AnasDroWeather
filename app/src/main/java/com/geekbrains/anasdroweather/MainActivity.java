package com.geekbrains.anasdroweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import com.geekbrains.anasdroweather.interfaces.ActivMethods;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements ActivMethods {

    MyData myData;
    int currentWeathPlaceId;
    int dayWeathPlaceId;
    int weekWeathPlaceId;

    CurrentWeatherFragment curWeathFragment;
    DayWeatherFragment dayWeathFragment;
    WeekWeatherFragment weekWeatherFragment;

    InterfaceChanger interfaceChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myData = MyData.getInstance();
        init();
//создаём изменитель интерфейса
        interfaceChanger = new InterfaceChanger(this);
//изменяем тему, если это возможно, в соответствии с текущим временем
        interfaceChanger.setAutoTheme();

    }

    @Override
    public void init() {
        currentWeathPlaceId = R.id.currentWeatherFrame;
        dayWeathPlaceId = R.id.dayWeatherFrame;
        weekWeathPlaceId = R.id.weekWeatherFrame;

        curWeathFragment = new CurrentWeatherFragment(currentWeathPlaceId);
        curWeathFragment.postFragment(this);
        Log.d("MainActivity", "Posted CurrentWeatherFragment");

        dayWeathFragment = new DayWeatherFragment(dayWeathPlaceId);
        dayWeathFragment.postFragment(this);
        Log.d("MainActivity", "Posted DayWeatherFragment");

        weekWeatherFragment = new WeekWeatherFragment(weekWeathPlaceId);
        weekWeatherFragment.postFragment(this);
        Log.d("MainActivity", "Posted WeekWeatherFragment");

    }






}
