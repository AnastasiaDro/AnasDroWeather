package com.geekbrains.anasdroweather;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public interface FragmentMethods {
    //находит кнопки и т.п.
    public void findViews(View view);
    //вставляет фрагмент
    public void postFragment(AppCompatActivity activity);
}

