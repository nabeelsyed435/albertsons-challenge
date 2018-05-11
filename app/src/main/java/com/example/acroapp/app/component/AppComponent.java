package com.example.acroapp.app.component;

import com.example.acroapp.app.module.NetworkModule;
import com.example.acroapp.app.module.SchedulersModule;
import com.example.acroapp.service.api.NactemAPI;
import com.example.acroapp.service.module.NactemAPIModule;
import com.example.acroapp.util.RxSchedulers;

import javax.inject.Singleton;

import dagger.Component;
import rx.Scheduler;

/**
 * The {AppComponent} is the principal Dagger component interface and makes sure that app wide
 * dependencies are provided and remain as singleton instances
 */
@Singleton
@Component(modules = {
        NetworkModule.class,
        NactemAPIModule.class,
        SchedulersModule.class
})
public interface AppComponent {

    /**
     * Provides the instance of the configured {@link NactemAPI} endpoint interface
     * @return The concrete instance for the {@link NactemAPI} retrofit interface
     */
    NactemAPI nactemApi();

    /**
     * Provides the instance of {@link RxSchedulers}for dependent sub-components
     * @return The concrete instance for the {@link RxSchedulers} interface
     */
    RxSchedulers schedulers();

}
