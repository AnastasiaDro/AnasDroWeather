package com.geekbrains.anasdroweather;

import com.geekbrains.anasdroweather.interfaces.Observable;
import com.geekbrains.anasdroweather.interfaces.Observer;

import java.util.LinkedList;
import java.util.List;


//Класс с данными, наблюдаемый
public class MyData implements Observable {
    private static MyData instance;
    private List<Observer> observers;

    private MyData() {
        observers = new LinkedList<>();
    }

//сделаем наблюдаемый класс сингл-тоном
    public static MyData getInstance(){
        if (instance == null) {
            instance = new MyData();
        }
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
}
