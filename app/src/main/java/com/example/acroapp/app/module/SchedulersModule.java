package com.example.acroapp.app.module;

import com.example.acroapp.util.AppRxSchedulers;
import com.example.acroapp.util.RxSchedulers;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SchedulersModule {

    @Singleton
    @Provides
    public RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }

}