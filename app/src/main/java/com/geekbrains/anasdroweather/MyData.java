package com.geekbrains.anasdroweather;

import android.content.res.Resources;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.geekbrains.anasdroweather.interfaces.Observable;
import com.geekbrains.anasdroweather.interfaces.Observer;

import org.w3c.dom.ls.LSOutput;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;


//Класс с данными, наблюдаемый
public class MyData implements Observable {
    private static MyData instance;
    private List<Observer> observers;
    //узнаем время
    static Date currentDate;
    static int currentHour;
    //флаг автоматической смены темы
    public boolean autoThemeChanging;

    private MyData() {
        currentHour = 0;
        observers = new LinkedList<>();
        autoThemeChanging = true;
    }





//сделаем наблюдаемый класс сингл-тоном
    public static MyData getInstance(){
        if (instance == null) {
            instance = new MyData();
        }
//получим текущий час
        currentDate = new Date();
        currentDate.getTime();
        currentHour = takeCurrentHour(currentDate);
//вернём MyData
        return instance;
    }

//добавить наблюдателя
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

//удалить наблюдателя
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

//уведомить наблюдателей
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.updateViewData();
        }
    }
//данные о текущей погоде для CurrentWeatherFragment
    public void getDataForNow() {
        //заполнить
    }

//Высчитать текущий час
    private static int takeCurrentHour(Date currentDate) {
        DateFormat hourFormat = new SimpleDateFormat("HH", Locale.getDefault());
        String dateText = hourFormat.format(currentDate);
        currentHour = Integer.parseInt(dateText);
        Log.d("takeCurrentHour", String.valueOf(currentHour));

        return currentHour;
    }

//геттер текущего часа
    public int getCurrentHour(){
        return currentHour;
    }

//геттер флага возможности смены темы
    public boolean getAutoThemeChanging() {
        return autoThemeChanging;
    }

    public void setAutoThemeChanging(boolean canThemeChanging) {
        autoThemeChanging = canThemeChanging;
    }


}
