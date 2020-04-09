package com.geekbrains.anasdroweather;

import androidx.appcompat.app.AppCompatActivity;

import com.geekbrains.anasdroweather.interfaces.Observer;

public class InterfaceChanger implements Observer {
    MyData myData;
    AppCompatActivity activity;

    public InterfaceChanger(AppCompatActivity activity) {
        this.activity = activity;
        myData = MyData.getInstance();
    }

    //автоматически задаём тему, если это разрешено в MyData
    public void setAutoTheme() {
            if (myData.getAutoThemeChanging()){
                if (myData.getCurrentHour()<8 || myData.getCurrentHour()>= 15) {
                    activity.setTheme(R.style.MyDarkTheme);
                } else {
                    activity.setTheme(R.style.MyLightTheme);
                }
            }
        }

    @Override
    public void updateViewData() {
        //заполнить
    }
}
