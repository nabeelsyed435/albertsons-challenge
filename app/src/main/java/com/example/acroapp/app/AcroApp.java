package com.example.acroapp.app;

import android.app.Application;

import com.example.acroapp.app.component.AppComponent;
import com.example.acroapp.app.component.DaggerAppComponent;

/**
 *
 */
public class AcroApp extends Application {

    private static AppComponent daggerAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDaggerAppComponent();
    }

    private void initDaggerAppComponent() {
        daggerAppComponent = DaggerAppComponent.builder().build();
    }

    public static AppComponent getDaggerAppComponent() {
        return daggerAppComponent;
    }
}
