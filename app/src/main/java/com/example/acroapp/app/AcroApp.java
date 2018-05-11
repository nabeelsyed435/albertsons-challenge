package com.example.acroapp.app;

import android.app.Application;

import com.example.acroapp.app.component.AppComponent;
import com.example.acroapp.app.component.DaggerAppComponent;

/**
 * AcroApp serves as a point to ensure that the {@link AppComponent} dependencies remain truly
 * singleton and it would also be the place to setup other tools like loggers such as Timber,
 * profiling tools such as Stetho and LeakCanary
 */
public class AcroApp extends Application {

    private static AppComponent daggerAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDaggerAppComponent();
    }

    /**
     * Helper private method to construct the {@link AppComponent} interface
     */
    private void initDaggerAppComponent() {
        daggerAppComponent = DaggerAppComponent.builder().build();
    }

    /**
     * Static method to obtain the {@link AppComponent} instance and be able to inject depending
     * sub-components
     * @return the {@link AppComponent} instance
     */
    public static AppComponent getDaggerAppComponent() {
        return daggerAppComponent;
    }

}
