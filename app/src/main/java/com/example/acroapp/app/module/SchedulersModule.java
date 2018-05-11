package com.example.acroapp.app.module;

import com.example.acroapp.util.AppRxSchedulers;
import com.example.acroapp.util.RxSchedulers;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * SchedulersModule is a dagger module class that would provide the different Schedulers abstracted </br>
 * by the {@link RxSchedulers} interface. RxJava posses various {@link rx.schedulers.Schedulers} and
 * RxAndroid offers the relevant schedulers to interact with the main thread through the {@link rx.android.schedulers.AndroidSchedulers}
 */
@Module
public class SchedulersModule {

    /**
     * Provider method to return the instance of the {@link RxSchedulers}
     * @return the concrete instance of the {@link RxSchedulers} interface
     */
    @Singleton
    @Provides
    public RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }

}