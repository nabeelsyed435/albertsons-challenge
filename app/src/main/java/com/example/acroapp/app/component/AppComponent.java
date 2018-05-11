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
 *
 */
@Singleton
@Component(modules = {
        NetworkModule.class,
        NactemAPIModule.class,
        SchedulersModule.class
})
public interface AppComponent {

    /**
     *
     * @return
     */
    NactemAPI nactemApi();
    RxSchedulers schedulers();

}
