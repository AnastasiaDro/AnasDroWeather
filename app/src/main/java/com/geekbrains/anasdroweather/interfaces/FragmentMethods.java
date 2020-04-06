package com.geekbrains.anasdroweather.interfaces;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public interface FragmentMethods {
    //находит кнопки и т.п.
    void findViews(View view);
    //вставляет фрагмент
    public void postFragment(AppCompatActivity activity);
}

