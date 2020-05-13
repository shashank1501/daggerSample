package com.example.daggersample;

import android.app.Application;

import com.example.daggersample.di.AppComponent;
import com.example.daggersample.di.DaggerAppComponent;


public class MainApplication extends Application {

    private AppComponent component;

    @Override public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.factory().create(this);
    }

    public AppComponent component() {
        return component;
    }

}
